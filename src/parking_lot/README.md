# 🅿️ Parking Lot System

## 📌 Overview
The **Parking Lot System** is a console-based application designed to manage parking spots for different vehicle types, including **cars**, **bikes**, and **trucks**. The system enables users to park and exit vehicles, view the parking lot status, and calculate parking fees dynamically based on parking duration and vehicle type. It provides a seamless experience for parking management with real-time availability and ticketing.

## ✅ Features
- 🏁 **Park Vehicles** in available spots based on vehicle type (Car, Bike, Truck)
- 💰 **Dynamic Fee Calculation** based on parking duration and vehicle type
- 🅿️ **Spot Allocation** for Car, Bike, and Truck categories
- 🛠️ **Manage Parking Lot Overview** and track parked vehicle details
- 🎫 **Ticketing System** for each parked vehicle, including entry/exit time and fees
- 🕓 **Track Entry** and **Exit Times** for accurate fee calculation
- 💡 **Real-time Parking Spot Availability**
- 🚗 **Set Vehicle Rates** dynamically while initializing the parking lot
---

## 📂 Package Structure
```
src/
│── parking_lot/
│   ├── parking/            # Parking spot management and allocation
│   ├── ticket/             # Ticket generation and fee calculation
│   ├── vehicle/            # Vehicle-related logic and types (Car, Bike, Truck)
│   ├── ParkingLotApp.java  # Main entry point for the Parking Lot system
│   ├── README.md           # Documentation (this file)
```

## 🏛️ Class Structure
```
│── ParkingLotApp (Main Class) 🚀
│   ├── Entry point of the application
│   ├── Initializes parking lot with vehicle type counts and rates
│   ├── Provides the menu for user interaction with the parking lot system
│   ├── Handles parking, exiting, and viewing of parked vehicles
│
📦 parking/
│── ParkingLot (Class) 🚗
│   ├── Manages parking spot allocation for cars, bikes, and trucks
│   ├── Tracks active tickets and vehicle assignments to parking spots
│   ├── Supports dynamic fee calculation based on parking duration and vehicle type
│   ├── Provides overview of available and occupied parking spots
│── ParkingSpot (Class) 🅿️
│   ├── Represents a single parking spot in the parking lot
│   ├── Manages vehicle assignments and releases the spot
│   ├── Determines if the spot is occupied or available
│
📦 ticket/
│── FeeCalculator (Class) 💸
│   ├── Provides the logic for dynamic fee calculation based on vehicle type and parking time
│   ├── Allows setting of custom rates for different vehicle types
│── Ticket (Class) 🎫
│   ├── Represents a parking ticket issued to a vehicle
│   ├── Stores ticket ID, vehicle information, parking spot, and entry/exit times
│   ├── Calculates the fee based on parking duration and vehicle type
│
📦 vehicle/
│── Vehicle (Class) 🚙
│   ├── Represents a vehicle with its number and type (Car, Bike, Truck)
│   ├── Provides methods to retrieve the vehicle type and number
│── VehicleType (Enum) 🚗
│   ├── Defines vehicle types: Car, Bike, and Truck
│   ├── Maps vehicle type to its respective name
```

## ▶️ How to Run
```
# Compile the Java files
$ javac parking_lot/*.java parking_lot/parking/*.java parking_lot/ticket/*.java parking_lot/vehicle/*.java

# Run the application
$ java parking_lot.ParkingLotApp
```

## 🎮 User Interaction
1. 🔧 **Initialize the Parking Lot**
    - Enter the **number of spots** and **hourly rates** for **Bike**, **Car**, and **Truck**.
2. 🚗 **Park a Vehicle**
    - Choose a **vehicle type** (Bike, Car, Truck) and enter the **vehicle number**.
    - The system will **assign an available parking spot** based on the vehicle type.
    - A **unique ticket** with an **entry time** will be generated.
3. ⬅️ **Exit a Vehicle (Unpark a Vehicle / Leave from the Parking Lot)**
    - Enter the **Ticket ID** when the vehicle leaves the parking lot.
    - The system calculates the **fee** based on the vehicle's **parking duration**.
    - The parking spot will be **released** and marked as available.
4. 📊 **View Parking Lot Overview**
    - View the **summary** of available and occupied spots for each vehicle type.
5. 📋 **View Parked Vehicle Details**
    - See details about the **currently parked vehicles**, including:
        - **Vehicle number**
        - **Assigned parking spot**
        - **Ticket ID**
6. ❌ **Exit Application**
    - Ends the session and prints a **thank you** message.
---

© 2025 Parking Lot System 🚗
