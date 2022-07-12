package planetest;

abstract class PlaneTest {
	
//	//생성된 객체의 정보 출력 method
//	public static void printInformation(Airplane l747,Cargoplane c40) {
//		System.out.println("Plane\t\tFuelSize");
//		System.out.println("-------------------------");
//		System.out.println(l747.getPlaneName()+" \t\t "+l747.getFuelSize());
//		System.out.println(c40.getPlaneName()+" \t\t "+c40.getFuelSize()+"\n");
//	}
	//문서에 없는 method 생성 지양
	
	public static void main(String[] args) {
		//Airplane과 Cargoplane 객체 생성
		Airplane l747 = new Airplane("L747",1000);
		Cargoplane c40 = new Cargoplane("C40",1000);
		
		//생성된 객체의 정보 출력
		System.out.println("Plane\t\tFuelSize");
		System.out.println("-------------------------");
		System.out.println(l747.getPlaneName()+" \t\t "+l747.getFuelSize());
		System.out.println(c40.getPlaneName()+" \t\t "+c40.getFuelSize()+"\n");

		//Airplane과 Cargoplane 객체에 100씩 운항
		
		l747.flight(100);
		c40.flight(100);
		//운항 후 객체의 변경된 정보 출력
		System.out.println("Plane\t\tFuelSize");
		System.out.println("-------------------------");
		System.out.println(l747.getPlaneName()+" \t\t "+l747.getFuelSize());
		System.out.println(c40.getPlaneName()+" \t\t "+c40.getFuelSize()+"\n");

		//Airplane과 Cargoplane 객체에 200씩 주유
		l747.refuel(200);
		c40.refuel(200);
		//운항 후 객체의 변경된 정보 출력
		System.out.println("Plane\t\tFuelSize");
		System.out.println("-------------------------");
		System.out.println(l747.getPlaneName()+" \t\t "+l747.getFuelSize());
		System.out.println(c40.getPlaneName()+" \t\t "+c40.getFuelSize()+"\n");
		
	}
	
}
