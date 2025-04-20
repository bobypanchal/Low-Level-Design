package parking_lot.ticket;

import java.time.Duration;
import java.time.LocalDateTime;

import parking_lot.parking.ParkingSpot;
import parking_lot.vehicle.Vehicle;

public class Ticket {

	private final String ticketId;
	private final Vehicle vehicle;
	private final ParkingSpot parkingSpot;
	private final LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private double amountPaid;

	public Ticket(int ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
		this.ticketId = "TICKET_" + ticketId;
		this.vehicle = vehicle;
		this.parkingSpot = parkingSpot;
		this.entryTime = LocalDateTime.now();
	}

	public String getTicketId() {
		return ticketId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}

	public long getParkingDuration() {
		if (this.exitTime == null)
			return 0;
		return (long) Math.ceil(Duration.between(this.entryTime, this.exitTime).getSeconds() / 60.0);
	}

	public void setAmountPaid(double amount) {
		this.amountPaid = amount;
	}

	public double getAmountPaid() {
		return amountPaid;
	}
}
