package parking_lot.ticket;

import java.util.HashMap;
import java.util.Map;

import parking_lot.vehicle.VehicleType;

public class FeeCalculator {

	private final Map<VehicleType, Integer> ratePerHour;

	public FeeCalculator(int bikeRate, int carRate, int truckRate) {
		ratePerHour = new HashMap<>();
		ratePerHour.put(VehicleType.BIKE, bikeRate);
		ratePerHour.put(VehicleType.CAR, carRate);
		ratePerHour.put(VehicleType.TRUCK, truckRate);
	}

	public double calculateFee(long durationInMinutes, VehicleType vehicleType) {
		return Math.ceil(durationInMinutes / 60.0) * ratePerHour.getOrDefault(vehicleType, 0);
	}
}
