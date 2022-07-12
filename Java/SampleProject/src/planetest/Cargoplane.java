package planetest;

public class Cargoplane extends Plane{
	
public Cargoplane() {
		
	}
	
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	
	@Override
	public void flight(int distance) {
		System.out.println(distance+" 운항");
		int s = distance / 10;
		super.setFuelSize(getFuelSize() - 50 * s);
		
	}
}
