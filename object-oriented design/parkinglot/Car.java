package system.design.parkinglot;

public class Car implements Vehicle{
	
	private VehicleType vehicleType;
	
	Car(VehicleType type){
		this.vehicleType = type;
	}

	@Override
	public VehicleSize getSize() {
		// TODO Auto-generated method stub
		return VehicleSize.MEDIUM;
	}

	@Override
	public VehicleType getType() {
		// TODO Auto-generated method stub
		return vehicleType;
	}

}
