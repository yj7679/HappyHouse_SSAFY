package com.ssafy.happyhouse.model.repo;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Member;

public interface MemberMapper {

	public Member login(Map<String, String> map) throws SQLException;
	public boolean insertMember(Member m); // DB에 회원 추가 하는 메소드
	public boolean update(Member member); // DB에 사용자의 정보를 수정하는 메소드
	public Member searchId(String id); // DB에 저장된 정보를 뽑아서 로그인 유효성 검사나 사용자 삭제, 사용자 수정 등에서 사용되는 메소드
	public void remove(String id); //DB에 사용자 삭제하는 메소드
	List<Member> searchAll(); //DB에 존재하는 사용자 모두 리턴하는 메소드
}
