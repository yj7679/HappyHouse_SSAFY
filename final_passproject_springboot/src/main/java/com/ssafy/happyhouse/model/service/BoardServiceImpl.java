package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Board;
import com.ssafy.happyhouse.model.repo.BoardMapper;
//import com.ssafy.happyhouse.model.dao.MemberDAOImpl;

//서비스의 인터페이스를 구현
@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Board> list() {
		return sqlSession.getMapper(BoardMapper.class).list();
	}

	@Override
	public Board search(String isbn) {
		return sqlSession.getMapper(BoardMapper.class).search(isbn);
	}

	@Override
	public boolean create(Board post) {
		return sqlSession.getMapper(BoardMapper.class).create(post);
	}

	@Override
	public boolean modify(Board post) { 
		return sqlSession.getMapper(BoardMapper.class).modify(post);
	}

	@Override
	@Transactional
	public boolean delete(String isbn) {
		return sqlSession.getMapper(BoardMapper.class).delete(isbn);
	}
}
