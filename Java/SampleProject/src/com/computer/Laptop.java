package com.computer;

public class Laptop extends Computer implements Graphic{

	public Laptop() {
		super();
	}

	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory,battery);
	}

	@Override
	public void operate(int time) {
		if (time >= 10) {
			super.setBattery(this.getBattery() - (time / 10));
		}
	}
	
	@Override
	public double rendering(int size) {
		return (double)size/(getCpu()*getMemory())*20;
	}
	
}
