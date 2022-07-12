package lecture220712;



class Person extends Object{
	String name;
	String mobile;
	public void printAll() {
		System.out.println("Print All!");
	}
}

class Student extends Person{
	String name; //field 재정의는 권장하지 않으며 일반적이지 않다
	String dept;
	
	//default constructor
	public Student() {
		this("홍길동"); //현재 내가 가진 다른 생성자 호출(name 인자 들어가는 Student 생성자)
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public void printAll() {
		System.out.println("Overriding!");
	}
}

public class Base {
	public static void main(String[] args) {
		Person s = new Student();
		s.printAll(); //Overriding!
	}
}
