package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.Board;

public interface BoardMapper {

	List<Board> list();
	Board search(String isbn);
	boolean create(Board post);
	boolean modify(Board post);
	void deleteComment(String isbn);
	boolean delete(String isbn);
	
}
