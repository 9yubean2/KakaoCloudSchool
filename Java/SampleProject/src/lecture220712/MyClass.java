package lecture220712;

public class MyClass {
	//fields
	int aaa;
	static int bbb = staticCall();
	
	//constructor
	public MyClass() {
		//근데 어차피 deafult 삽입되는데 굳이 써야돼?..
		//웅 써!
	}
	
	//static block
	static {
		//main 실행 직전 library같은 것들을 loading할 필요가 있을 때
		System.out.println("static block");
	}
	
	//methods
	static int staticCall() {
		System.out.println("staticCall invoked!");
		return 100;
	}
	
	public static void main(String[] args) {
		System.out.println("main invoked!");
	}
}

//staticCall invoked!
//static block
//main invoked!
