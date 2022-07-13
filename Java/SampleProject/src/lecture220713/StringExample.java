package lecture220713;

public class StringExample {
	public static void main(String[] args) {
		String a = "Hello";
		String b = "Hello";
		String c = new String("Hello");
		
		System.out.println(a == b);//true
		System.out.println(a == c);//false
		
		System.out.println(a.equals(c));//true
		
	}
}
