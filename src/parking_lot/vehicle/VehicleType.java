package parking_lot.vehicle;

public enum VehicleType {

	BIKE("Bike"), CAR("Car"), TRUCK("Truck");

	private final String name;

	VehicleType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static VehicleType fromString(String value) {
		try {
			return VehicleType.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
