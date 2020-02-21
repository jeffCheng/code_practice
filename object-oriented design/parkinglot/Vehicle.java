package system.design.parkinglot;

public interface Vehicle {
	enum VehicleSize {
		SMALL,
		MEDIUM,
		LARGE
	}
	enum VehicleType{
		REGULAR,
		HANDICAP
	}
	
	VehicleSize getSize();
	VehicleType getType();
}
