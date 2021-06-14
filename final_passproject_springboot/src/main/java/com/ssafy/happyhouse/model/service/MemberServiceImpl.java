package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Member;
//import com.ssafy.happyhouse.model.dao.MemberDAOImpl;
import com.ssafy.happyhouse.model.repo.MemberMapper;

//서비스의 인터페이스를 구현
@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public boolean insertMember(Member m) {
		return sqlSession.getMapper(MemberMapper.class).insertMember(m);
	}

	@Override
	public List<Member> searchAll() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapper.class).searchAll();
	}

	@Override
	public Member login(Map<String, String> map) throws SQLException {
		System.out.println(map.get("userid"));
		System.out.println(map.get("userpwd"));
		if(map.get("userid") == null || map.get("userpwd") == null) return null;
		return sqlSession.getMapper(MemberMapper.class).login(map);
	}

	@Override
	public Member searchId(String id) {
		return sqlSession.getMapper(MemberMapper.class).searchId(id);
	}

	@Override
	public boolean update(Member member) {
		return sqlSession.getMapper(MemberMapper.class).update(member);
	}

	@Override
	public void remove(String id) {
		sqlSession.getMapper(MemberMapper.class).remove(id);

	}

}
