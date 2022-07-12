package lecture220712;

public class InstanceTest {
	//fields
	int a = myCall("1번"); //instance
	static int b = myCall("2번"); //static

	//constructor
	public InstanceTest() {
		
	}
	
	//business method
	public static int myCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	public void printMsg(String msg) {
		int a = 100;
		System.out.println(msg);
	}
	
}
