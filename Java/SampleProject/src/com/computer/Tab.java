package com.computer;

public class Tab extends Computer implements Graphic{

	//constructors
	public Tab() {
		super();
	}

	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory,battery);
	}
	
	//methods
	@Override
	public void operate(int time) {
		if (time >= 5) {
			super.setBattery(getBattery() - (time / 5));
		}
	}
	
	@Override
	public double rendering(int size) {
		
		return (double)size/(getCpu()*getMemory())*30;
	}

}
