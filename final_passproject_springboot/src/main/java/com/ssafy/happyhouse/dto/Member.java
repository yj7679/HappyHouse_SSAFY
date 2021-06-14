package com.ssafy.happyhouse.dto;
//사용자의 정보 - 아이디, 비밀번호,이름, 이메일, 핸드폰번호, 주소
public class Member {

	String id;
	String pwd;
	String name;
	String email;
	String phone;
	String address;
	int dongcode;
	
	
	public Member() {
		super();
	}
	public Member(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public Member(String id, String pwd, String name, String email, String phone, String address) {
		super();

		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dongcode =-1;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", dongcode=" + dongcode + "]";
	}
	
	
}
