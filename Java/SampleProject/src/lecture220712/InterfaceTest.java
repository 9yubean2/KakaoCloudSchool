package lecture220712;

interface myInterface {
	//field
	//public static final 자동 설정
	int kk = 0;
	String aa = "Hello";
	
	//methods
	public abstract void printAll();
	public abstract void myPrint();
}
public class InterfaceTest implements myInterface{
	
	//is-a relationship, type conversion도 가능
	
	@Override
	public void printAll() {
		// TODO Auto-generated method stub
	}

	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
	}
	
}
