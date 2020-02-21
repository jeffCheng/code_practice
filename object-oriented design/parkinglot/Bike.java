package system.design.parkinglot;

public class Bike implements Vehicle {
	private VehicleType vehicleType;
	
	Bike(VehicleType type){
		this.vehicleType = type;
	}

	@Override
	public VehicleSize getSize() {
		// TODO Auto-generated method stub
		return VehicleSize.SMALL;
	}

	@Override
	public VehicleType getType() {
		// TODO Auto-generated method stub
		return vehicleType;
	}

}
