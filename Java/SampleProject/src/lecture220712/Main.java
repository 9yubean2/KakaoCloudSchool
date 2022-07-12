package lecture220712;

public class Main {
	//default constructor 있음
	public static void main(String[] args) {
		InstanceTest test;
		System.out.println("3번");
		int k = InstanceTest.myCall("4번");
		test = new InstanceTest();
		test.printMsg("5번");
	}
}
