package com.computer;

public abstract class Computer {
	//fields
	private String name;
	private int cpu;
	private int memory;
	private int battery;
	
	//constructor
	public Computer() {
		super();
	}
	
	public Computer(String name, int cpu, int memory, int battery) {
		super();
		this.setName(name);
		this.setCpu(cpu);
		this.setMemory(memory);
		this.setBattery(battery);

	}
	
	//getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	//method
	public abstract void operate(int time);

}
