package com.shape;
import java.awt.Point;

public class Circle extends Shape implements Movable{
	
	//fields
	public int radius;
	
	
	//constructors
	public Circle () {
		super();
	}
	
	public Circle(int radius,int x, int y) {
		super(new Point (x,y));
		this.radius = radius;
	}

	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	//methods
	@Override
	public double getArea() {
		return Math.PI*this.radius*this.radius;
	}

	@Override
	public double getCircumference() {
		return 2*Math.PI*this.radius;
	}
	
	@Override
	public void move(int x, int y) {
		this.setPoint(new Point((int)(getPoint().getX()+(x+1)),(int)(getPoint().getY()+(y+1))));
	}


}
