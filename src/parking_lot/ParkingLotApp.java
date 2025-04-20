package parking_lot;

import java.util.Scanner;

import parking_lot.parking.ParkingLot;
import parking_lot.parking.ParkingSpot;
import parking_lot.ticket.FeeCalculator;
import parking_lot.ticket.Ticket;
import parking_lot.vehicle.Vehicle;
import parking_lot.vehicle.VehicleType;

public class ParkingLotApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Initialize Parking Lot Capacity:");
		System.out.print("Number of Bike spots: ");
		int bikeCount = scanner.nextInt();
		System.out.print("Hourly rate for Bike: ");
		int bikeRate = scanner.nextInt();

		System.out.print("Number of Car spots: ");
		int carCount = scanner.nextInt();
		System.out.print("Hourly rate for Car: ");
		int carRate = scanner.nextInt();

		System.out.print("Number of Truck spots: ");
		int truckCount = scanner.nextInt();
		System.out.print("Hourly rate for Truck: ");
		int truckRate = scanner.nextInt();
		scanner.nextLine();

		FeeCalculator feeCalculator = new FeeCalculator(bikeRate, carRate, truckRate);
		ParkingLot parkingLot = new ParkingLot(bikeCount, carCount, truckCount, feeCalculator);

		while (true) {
			System.out.print("\n1. Park Vehicle\n2. Exit Vehicle\n3. Parking Lot Overview\n4. Parked Vehicle Details\n5. Exit App\nChoose an option: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			if (option == 1) {
				System.out.print("Enter Vehicle Type (Bike, Car, Truck): ");
				VehicleType vehicleType = VehicleType.fromString(scanner.nextLine());
				if (vehicleType == null) {
					System.out.println("Invalid vehicle type!");
					break;
				}

				ParkingSpot parkingSpot = parkingLot.getAvailableSpot(vehicleType);
				if (parkingSpot == null) {
					System.out.println("No spot available for " + vehicleType);
					continue;
				}

				System.out.print("Enter Vehicle Number: ");
				String vehicleNumber = scanner.nextLine().toUpperCase();

				Ticket ticket = parkingLot.assignSpot(parkingSpot, new Vehicle(vehicleNumber, vehicleType));
				System.out.println(vehicleType.getName() + " successfully parked at spot " + parkingSpot.getSpotId() + ". Ticket ID: " + ticket.getTicketId());
			} else if (option == 2) {
				System.out.print("Enter Ticket ID: ");
				Ticket ticket = parkingLot.releaseSpot(scanner.nextLine().toUpperCase());
				if (ticket != null)
					System.out.println(ticket.getVehicle().getType() + " " + ticket.getVehicle().getNumber() + " exited. Parking duration: " + ticket.getParkingDuration() + " minutes. Amount paid: " + ticket.getAmountPaid());
				else
					System.out.println("Invalid ticket ID! Please enter valid Ticket ID.");
			} else if (option == 3) {
				parkingLot.overview();
			} else if (option == 4) {
				parkingLot.parkedVehicleDetails();
			} else if (option == 5) {
				System.out.println("Thank you for using the Parking Lot! Have a great day!");
				scanner.close();
				return;
			} else {
				System.out.println("Invalid option.");
			}
		}
	}
}
