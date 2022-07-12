package planetest;

abstract public class Plane {
	
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		
	}
	
	public Plane(String planeName, int fuelSize) {
//		this.planeName = planeName;
//		this.fuelSize = fuelSize;
		this.setPlaneName(planeName);
		this.setFuelSize(fuelSize);
	}
	
	public void refuel(int fuel) {
		//this.fuelSize += fuel; field 직접 access 지양
		this.setFuelSize(this.getFuelSize()+fuel);
	}
	
	//abstract method
	public abstract void flight(int distance);

	
	//Getter&Setter
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	
}
