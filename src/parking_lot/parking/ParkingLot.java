package parking_lot.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import parking_lot.ticket.FeeCalculator;
import parking_lot.ticket.Ticket;
import parking_lot.vehicle.Vehicle;
import parking_lot.vehicle.VehicleType;

public class ParkingLot {

	private final List<ParkingSpot> carSpots;
	private final List<ParkingSpot> bikeSpots;
	private final List<ParkingSpot> truckSpots;
	private final FeeCalculator feeCalculator;
	private final Map<String, Ticket> activeTickets = new LinkedHashMap<>();
	private int ticketCounter = 1;

	public ParkingLot(int bikeCount, int carCount, int truckCount, FeeCalculator feeCalculator) {
		this.bikeSpots = createSpots(bikeCount, VehicleType.BIKE);
		this.carSpots = createSpots(carCount, VehicleType.CAR);
		this.truckSpots = createSpots(truckCount, VehicleType.TRUCK);
		this.feeCalculator = feeCalculator;
	}

	private List<ParkingSpot> createSpots(int count, VehicleType vehicleType) {
		List<ParkingSpot> spots = new ArrayList<>();
		for (int i = 1; i <= count; i++)
			spots.add(new ParkingSpot(vehicleType.getName().charAt(0) + "_" + i));
		return spots;
	}

	public Ticket assignSpot(ParkingSpot spot, Vehicle vehicle) {
		Ticket ticket = new Ticket(ticketCounter++, vehicle, spot);
		spot.assignVehicle(vehicle);
		activeTickets.put(ticket.getTicketId(), ticket);
		return ticket;
	}

	public Ticket releaseSpot(String ticketId) {
		Ticket ticket = activeTickets.get(ticketId);
		if (ticket == null) {
			System.out.println("Invalid ticket ID");
			return null;
		}

		ticket.setExitTime(LocalDateTime.now());
		double amount = feeCalculator.calculateFee(ticket.getParkingDuration(), ticket.getVehicle().getType());
		ticket.setAmountPaid(amount);

		ticket.getParkingSpot().releaseSpot();
		activeTickets.remove(ticketId);
		return ticket;
	}

	public ParkingSpot getAvailableSpot(VehicleType vehicleType) {
		if (vehicleType == VehicleType.BIKE) {
			return bikeSpots.stream().filter(ParkingSpot::isNotOccupied).findFirst().orElse(null);
		} else if (vehicleType == VehicleType.CAR) {
			return carSpots.stream().filter(ParkingSpot::isNotOccupied).findFirst().orElse(null);
		} else if (vehicleType == VehicleType.TRUCK) {
			return truckSpots.stream().filter(ParkingSpot::isNotOccupied).findFirst().orElse(null);
		} else {
			return null;
		}
	}

	public void overview() {
		long availableBikes = bikeSpots.stream().filter(ParkingSpot::isNotOccupied).count();
		long availableCars = carSpots.stream().filter(ParkingSpot::isNotOccupied).count();
		long availableTrucks = truckSpots.stream().filter(ParkingSpot::isNotOccupied).count();

		System.out.println("Parking Lot Overview");
		System.out.println("----------------------------------------");
		System.out.printf("| %-12s | %-9s | %-9s |\n", "Vehicle Type", "Available", "Allocated");
		System.out.println("----------------------------------------");
		System.out.printf("| %-12s | %-9d | %-9d |\n", VehicleType.BIKE.getName(), availableBikes, bikeSpots.size() - availableBikes);
		System.out.printf("| %-12s | %-9d | %-9d |\n", VehicleType.CAR.getName(), availableCars, carSpots.size() - availableCars);
		System.out.printf("| %-12s | %-9d | %-9d |\n", VehicleType.TRUCK.getName(), availableTrucks, truckSpots.size() - availableTrucks);
		System.out.println("----------------------------------------");
	}

	public void parkedVehicleDetails() {
		System.out.println("Parked Vehicles Details");
		System.out.println("-----------------------------------------------------------");
		System.out.printf("| %-12s | %-12s | %-13s | %-9s |\n", "Vehicle Type", "Parking Spot", "Number Plate", "Ticket ID");
		System.out.println("-----------------------------------------------------------");
		for (Map.Entry<String, Ticket> entry : activeTickets.entrySet()) {
			Ticket ticket = entry.getValue();
			System.out.printf("| %-12s | %-12s | %-13s | %-9s |\n", ticket.getVehicle().getType(), ticket.getParkingSpot().getSpotId(), ticket.getVehicle().getNumber(), entry.getKey());
		}
		System.out.println("-----------------------------------------------------------");
	}
}
