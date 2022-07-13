package com.shape;

public class Rectangle extends Shape implements Movable{
	
	//fields
	public int width;


	//constructors
	public Rectangle () {
		super();
	}
	
	public Rectangle(int width,int x, int y) {
		super(new Point (x,y));
		this.width = width;
	}

	//getter&setter
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	//methods
	@Override
	public double getArea() {
		return getWidth()*getWidth();
	}

	@Override
	public double getCircumference() {
		return getWidth()*4;
	}
	
	@Override
	public void move(int x, int y) {
		this.setPoint(new Point((int)(getPoint().getX()+x+2),(int)(getPoint().getY()+y+2)));
		
	}
	
	public String toString() {
		return String.format("%s %5s %5s %5s", this.getClass().getSimpleName(),
				this.getWidth(), this.getPoint().getX(), this.getPoint().getY());	
	}	


}
