package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Qna;
import com.ssafy.happyhouse.model.repo.QnaMapper;
//import com.ssafy.happyhouse.model.dao.MemberDAOImpl;

//서비스의 인터페이스를 구현
@Service
public class QnaServiceImpl implements QnaService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Qna> list() {
		return sqlSession.getMapper(QnaMapper.class).list();
	}

	@Override
	public Qna search(String isbn) {
		return sqlSession.getMapper(QnaMapper.class).search(isbn);
	}

	@Override
	public boolean create(Qna post) {
		return sqlSession.getMapper(QnaMapper.class).create(post);
	}

	@Override
	public boolean modify(Qna post) { 
		return sqlSession.getMapper(QnaMapper.class).modify(post);
	}

	@Override
	@Transactional
	public boolean delete(String isbn) {
		return sqlSession.getMapper(QnaMapper.class).delete(isbn);
	}
}
