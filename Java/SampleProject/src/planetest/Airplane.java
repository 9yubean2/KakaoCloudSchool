package planetest;

public class Airplane extends Plane{

	public Airplane() {
		
	}
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	
	@Override
	public void flight(int distance) {
		System.out.println(distance+" 운항");
		int s = distance / 10;
		super.setFuelSize(getFuelSize() - 30 * s);
		
	}

}
