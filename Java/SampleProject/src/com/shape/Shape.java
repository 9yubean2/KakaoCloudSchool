package com.shape;

public abstract class Shape extends Point{
	//fields
	protected Point point;

	//constructors
	public Shape() {
		
	}
	
	public Shape(Point point) {
		super();
		this.point = point;
	}

	//getter&setter
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	//methods
	public abstract double getArea();
	public abstract double getCircumference();

}
