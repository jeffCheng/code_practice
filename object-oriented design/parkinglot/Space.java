package system.design.parkinglot;

public interface Space extends Vehicle{
	boolean getIsTaken();
	void setIsTaken(boolean isTaken);
}
