package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Member;

//서비스를 제공하기위해서 DAO를 만들어서 서비스를 제공한다.
public interface MemberService {
	public Member login(Map<String, String> map) throws SQLException; //로그인 서비스 
	//public void insertMember(Member member);//회원가입 서비스
	public boolean insertMember(Member m);//회원가입 서비스	
	public Member searchId(String id);//ID 유효성, 회원 정보수정, 회원 삭제 서비스에 필요한 메소드
	public boolean update(Member member);//정보 수정 메소드
	public void remove(String id);//회원 삭제 메소드
	List<Member> searchAll(); //전체 회원 반환 메소드
}
