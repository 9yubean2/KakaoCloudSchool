package lecture220712;

class Superclass {
	
	//fields
	int a = staticCall("1번입니다.");
	static int b = staticCall("2번입니다.");
	
	//constructors
	public Superclass() {
		staticCall("3번입니다.");
	}
	//constructors(overloading)	
	public Superclass(int i) {
		this();
		staticCall("4번입니다.");
	}
	
	//static method
	static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	//method
	public void myFunc() {
		System.out.println("5번입니다.");
	}
}

public class InheritanceTest extends Superclass {
	//fields
	int c = staticCall("6번입니다.");
	static int b = staticCall("7번입니다.");
	
	//constructors
	public InheritanceTest() {
		super(100);
		staticCall("8번입니다.");
		super.myFunc();
	}
	
	@Override
	public void myFunc() {
		System.out.println("9번입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("10번입니다.");
		Superclass obj = new InheritanceTest();
		obj.myFunc();
	}
}
