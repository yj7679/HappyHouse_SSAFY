package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.Qna;

public interface QnaMapper {

	List<Qna> list();
	Qna search(String isbn);
	boolean create(Qna post);
	boolean modify(Qna post);
	void deleteComment(String isbn);
	boolean delete(String isbn);
	
}
