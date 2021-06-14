package com.ssafy.happyhouse.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.dto.Qna;
import com.ssafy.happyhouse.model.service.QnaService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vuews/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/post")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	QnaService postService;

	@ApiOperation(value = "모든 책의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Qna>> listBook() {
		logger.debug("listBook - 호출");
		return new ResponseEntity<>(postService.list(), HttpStatus.OK);
	}

	@ApiOperation(value = "번호에 해당하는 qna의 정보를 반환한다.", response = Qna.class)
	@GetMapping("/{isbn}")
	public ResponseEntity<Qna> searchBook(@PathVariable String isbn) {
		logger.debug("searchBook - 호출");
		return new ResponseEntity<>(postService.search(isbn), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 qna를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBook(@RequestBody Qna post) {
		logger.debug("createBook - 호출");
		if(postService.create(post)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "isbn에 해당하는 책의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{isbn}")
	public ResponseEntity<String> modifyBook(@RequestBody Qna post) {
		logger.debug("modifyBook - 호출");
		logger.debug("" + post);
		if(postService.modify(post)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "isbn에 해당하는 책의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{isbn}")
	public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn) {
		logger.debug("deleteBook - 호출");
		if(postService.delete(isbn)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
