package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Qna;

public interface QnaService {

	public List<Qna> list();

	public Qna search(String isbn);

	public boolean create(Qna post);

	public boolean modify(Qna post);

	public boolean delete(String isbn);
	
}
