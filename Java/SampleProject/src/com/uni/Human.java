package com.uni;

public class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Human() {
		
	}

	public Human(String name, int age, int height, int weight) {
//		this.name = name;
//		this.age = age;
//		this.height = height;
//		this.weight = weight;
		this.setName(name);
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
	}
	
	//Getter&Setter
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	

	//Business Method
	public String printInformation() {
		return getName()+"\t"+getAge()+"\t"+getHeight()+"\t"+getWeight();
	}
	
}
