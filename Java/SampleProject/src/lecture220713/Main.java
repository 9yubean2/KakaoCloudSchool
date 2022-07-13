package lecture220713;

class Student extends Object{

	//fields
	private String name;
	private int age;
	
	//constructors
	public Student() {
		
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//getter&setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student tmp = (Student)obj;
		boolean result = false; 
		if(this.name == tmp.name && this.age == tmp.age) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.name +" " + this.age;
	}
	
}

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동",20);
		Student s2 = new Student("홍길동",20);
//		System.out.println(s1 == s2);//false 메모리주소가 다르니까
//		//System.out.println(s1.equals(s2)); //false
//		//override 후
//		System.out.println(s1.equals(s2));//true
		
		//자동적으로 붙어서 실행된다
//		System.out.println(s1);//lecture220713.Student@1eb44e46
//		System.out.println(s1.toString());//lecture220713.Student@1eb44e46
		//override 후
		System.out.println(s1.toString()); //홍길동 20
	}
}
