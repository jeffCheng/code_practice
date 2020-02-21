
package system.design.parkinglot;

public class ParkingSpace implements Space {
	private VehicleSize vehicleSize;
	private VehicleType vehicleType;
	private boolean isTaken;
	
	public ParkingSpace(VehicleSize vehicleSize, VehicleType vehicleType) {
		this.vehicleSize = vehicleSize;
		this.vehicleType = vehicleType;
	}

	@Override
	public VehicleSize getSize() {
		return this.vehicleSize;
	}
	
	@Override
	public VehicleType getType() {
		return this.vehicleType;
	}

	@Override
	public boolean getIsTaken() {
		return isTaken;
	}

	@Override
	public void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

}
