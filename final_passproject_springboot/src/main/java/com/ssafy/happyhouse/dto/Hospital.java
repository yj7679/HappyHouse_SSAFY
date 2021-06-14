
package com.ssafy.happyhouse.dto;

public class Hospital {
	int hid;
	String sido;
	String sigungu;
	String name;
	String address;
	String contact;
	int type;
	
		
	public Hospital(int hid, String sido, String sigungu, String name, String address, String contact, int type) {
		super();
		this.hid = hid;
		this.sido = sido;
		this.sigungu = sigungu;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.type = type;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}