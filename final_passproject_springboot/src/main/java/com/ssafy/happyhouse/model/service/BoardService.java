package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;

import java.util.List;

import com.ssafy.happyhouse.dto.Board;

public interface BoardService {

	public List<Board> list();

	public Board search(String isbn);

	public boolean create(Board post);

	public boolean modify(Board post);

	public boolean delete(String isbn);
	
}
