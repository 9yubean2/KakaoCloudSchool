package com.kakao.test;

public class Student {
	//결론적으로 field는 특별한 이유가 없는한 싹다 private
	//class 내부의 field는 보호해야 하는 정보
	private String stuName; //information hiding
	private String stuNum;
	
	
	
	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getStuNum() {
		return stuNum;
	}


	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}


	public Student() {
		
	}

}

