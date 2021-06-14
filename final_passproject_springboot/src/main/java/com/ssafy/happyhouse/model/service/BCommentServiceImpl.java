package com.ssafy.happyhouse.model.service;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.model.repo.BCommentMapper;


@Service
public class BCommentServiceImpl implements BCommentService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CommentDto> list(String isbn) {
		return sqlSession.getMapper(BCommentMapper.class).list(isbn);
	}

	@Override
	public boolean create(CommentDto commentDto) {
		return sqlSession.getMapper(BCommentMapper.class).create(commentDto) == 1;
	}

	@Override
	public boolean modify(CommentDto commentDto) {
		return sqlSession.getMapper(BCommentMapper.class).modify(commentDto) == 1;
	}

	@Override
	public boolean delete(int commentNo) {
		return sqlSession.getMapper(BCommentMapper.class).delete(commentNo) == 1;
	}
}
