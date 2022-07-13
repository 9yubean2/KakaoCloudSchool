package com.shape;

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
		return Math.PI*this.getRadius()*this.getRadius();
	}

	@Override
	public double getCircumference() {
		return 2*Math.PI*this.getRadius();
	}
	
	@Override
	public void move(int x, int y) {
		//this.setPoint(new Point((int)(getPoint().getX()+(x+1)),(int)(getPoint().getY()+(y+1))));
		getPoint().setX(getPoint().getX()+(x+1));
		getPoint().setY(getPoint().getY()+(y+1));
	}
	
	@Override
	public String toString() {
		return String.format("%9s %5s %5s %5s",this.getClass().getSimpleName(),
				this.getRadius(), this.getPoint().getX(), this.getPoint().getY());
	}


}
