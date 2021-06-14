package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.CommentDto;



public interface BCommentMapper {

	List<CommentDto> list(String isbn);

	int create(CommentDto commentDto);

	int modify(CommentDto commentDto);

	int delete(int commentNo);
	
}
