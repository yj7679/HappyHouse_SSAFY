package com.ssafy.happyhouse.dto;

public class InterestArea {
	String memberid;
	String dong;
	
	
	
	public InterestArea() {
		super();
	}



	public InterestArea( String memberid, String dong) {
		super();
		this.memberid = memberid;
		this.dong = dong;
	}



	@Override
	public String toString() {
		return "InterestArea [dong=" + dong + ", memberid=" + memberid + "]";
	}
	
	
	
	
}
