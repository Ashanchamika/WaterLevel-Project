import java.util.Random;
class WaterLevelObserver{
   public void update(int waterLevel){}
}
class Alarm extends WaterLevelObserver{
   String alarmId;
   Alarm(String id){
       alarmId = id;
   }
   @Override
   public void update(int waterLevel){
       System.out.println("Alarm ("+alarmId+") triggered!"+(waterLevel>=50?"ON":"OFF"));
   }
}
class Display extends WaterLevelObserver{
   @Override
   public void update(int waterLevel){
       System.out.println("Water Level : "+waterLevel);
   }
}
class SMSSender extends WaterLevelObserver{
   @Override
   public void update(int waterLevel){
       System.out.println("Sending SMS.. : "+waterLevel);
   }
}
class Splitter extends WaterLevelObserver{
   @Override
   public void update(int waterLevel){
       System.out.println("Splitting : "+(waterLevel>=75?"Splitter ON":"Splitter OFF"));
   }
}


class ControlRoom{
   private WaterLevelObserver[] observerArray = new  WaterLevelObserver[100];
   private int nextIndex=0;
   private int waterLevel;


   public void addWaterLevelObserver(WaterLevelObserver observer){
       observerArray[nextIndex++] = observer;
   }






   public void notifyObjects(){
      for(int i=0;i<nextIndex;i++){
          observerArray[i].update(waterLevel);
      }
   }


   public void setWaterLevel(int waterLevel){
       if(this.waterLevel!=waterLevel){
           this.waterLevel = waterLevel;
           notifyObjects();
       }
   }
}


class Main{
   public static void main(String[] args){
       ControlRoom controlRoom = new ControlRoom();
       controlRoom.addWaterLevelObserver(new Alarm("1"));
       controlRoom.addWaterLevelObserver(new Display());
       controlRoom.addWaterLevelObserver(new SMSSender());
       controlRoom.addWaterLevelObserver(new Splitter());
       //
       Random random = new Random();
       while(true){
           int rand = random.nextInt(101); // 0-100
           controlRoom.setWaterLevel(rand);
           try{Thread.sleep(1000);}catch(Exception e){}
       }
   }
}
