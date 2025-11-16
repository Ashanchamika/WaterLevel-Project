🌊 Water Level Monitoring System (Observer Pattern in Java)

This project demonstrates a Water Level Monitoring System implemented using the Observer Design Pattern in Java.
Different components (Alarm, Display, SMS Sender, Splitter) act as observers and respond automatically whenever the water level changes.

🚀 Features
✔️ Observer Pattern Implementation

Multiple observers registered to a single subject (ControlRoom).

Each observer reacts differently when the water level updates.

✔️ Random Water Level Simulation

Water level changes every second (0–100).

Automatically triggers all subscribed observers.

✔️ Behavior of Observers
Observer	Action
Alarm	Turns ON when water level ≥ 50
Display	Shows current water level
SMS Sender	Sends SMS notification of level
Splitter	Activates when water level ≥ 75
🔧 How It Works

ControlRoom holds all observers.

When water level updates:

notifyObjects() calls update() on each observer.

Each observer performs its own action:

Alarm sounds

Display prints level

SMS sent

Splitter activates

🧩 Tech Used

Java OOP

Observer Design Pattern

Random Level Generator

Thread delay simulation

📂 Project Structure
Main.java
 ├── ControlRoom
 ├── WaterLevelObserver (base class)
 ├── Alarm
 ├── Display
 ├── SMSSender
 └── Splitter

▶️ How to Run

Compile:

javac Main.java


Run:

java Main


You will see real-time water level updates and observer reactions printed every second.

📌 Purpose

This project is ideal for learning:

How Observer Pattern works

How to decouple components

Event-based system design

Clean OOP practices in Java
