package com.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
	public static void main(String[] args) {
		//ArrayList에 객체 생성해서 넣는다
		List<Shape> list = new ArrayList<Shape>();
		list.add(new Rectangle(4,7,5));
		list.add(new Rectangle(5,4,6));
		list.add(new Circle(6,6,7));
		list.add(new Circle(7,8,3));
		
		
		//모든 객체의 넓이 정보와 둘레 정보를 출력(for, 소수점첫자리에서 반올림해서)
		System.out.println("구분"+"\t\t"+"길이"+"\t"+"x좌표"+"\t"+"y좌표"+"\t"+"Area"+"\t"+"Circumference");
		for (Shape s : list) {
			if(s.getClass().getSimpleName().compareTo("Rectangle")==0) {		
				System.out.println(s.getClass().getSimpleName()+"\t"+((Rectangle) s).getWidth()+"\t"+(int)(((Rectangle)s).getPoint().getX())+"\t"+(int)(((Rectangle)s).getPoint().getY())+"\t"+String.format("%.0f",((Rectangle)s).getArea())+"\t"+String.format("%.0f",((Rectangle)s).getCircumference()));
			}
			else {
				System.out.println(s.getClass().getSimpleName()+"\t\t"+((Circle) s).getRadius()+"\t"+(int)(((Circle) s).getPoint().getX())+"\t"+(int)(((Circle)s).getPoint().getY())+"\t"+String.format("%.0f",((Circle)s).getArea())+"\t"+String.format("%.0f",((Circle)s).getCircumference()));
			}
			
		}		

		/*
		for (int i =0;i<list.size();i++) {
			if(list.get(i).getClass().getSimpleName().compareTo("Rectangle")==0) {	
				((Rectangle) list.get(i)).move(10,10);
			}
			else {
				((Circle) list.get(i)).move(10,10);
			}
		}
		*/
		
		//모든 객체 move() x+10, y+10 후 객체 정보 출력 (for)
		for(Shape s : list ) {
			((Movable)s).move(10,10);
		}
		
		System.out.println("이동후...");
		
		
		for (Shape s : list) {
			if(s.getClass().getSimpleName().compareTo("Rectangle")==0) {	
				System.out.println(s.getClass().getSimpleName()+"\t"+((Rectangle)s).getWidth()+"\t"+(int)(((Rectangle) s).getPoint().getX())+"\t"+(int)(((Rectangle) s).getPoint().getY()));
			}
			else {
				System.out.println(s.getClass().getSimpleName()+"\t\t"+((Circle)s).getRadius()+"\t"+(int)(((Circle)s).getPoint().getX())+"\t"+(int)(((Circle)s).getPoint().getY()));
			}
		}
		
	}
}
