package system.design.parkinglot;

public class Truck implements Vehicle{
	
	private VehicleType vehicleType;
	
	Truck( VehicleType type){
		this.vehicleType = type;
	}

	@Override
	public VehicleSize getSize() {
		// TODO Auto-generated method stub
		return VehicleSize.LARGE;
	}

	@Override
	public VehicleType getType() {
		// TODO Auto-generated method stub
		return vehicleType;
	}

}
