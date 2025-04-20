package parking_lot.parking;

import parking_lot.vehicle.Vehicle;

public class ParkingSpot {

	private final String spotId;
	private Vehicle currentVehicle;

	public ParkingSpot(String spotId) {
		this.spotId = spotId;
		this.currentVehicle = null;
	}

	public String getSpotId() {
		return spotId;
	}

	public boolean isNotOccupied() {
		return this.currentVehicle == null;
	}

	public void assignVehicle(Vehicle vehicle) {
		this.currentVehicle = vehicle;
	}

	public void releaseSpot() {
		this.currentVehicle = null;
	}
}
