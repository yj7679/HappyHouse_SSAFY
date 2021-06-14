package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.model.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
@RequestMapping("/member")
public class MemberRestController {

	private static final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
	private static final String SUCCESS="success";
	private static final String FAIL = "fail";
	
	@Autowired
	MemberService memService;

	@ApiOperation(value = "사용자 정보를 DB에 입력 후 성공시 success, 실패시 fail 리턴 (문자열)", response = List.class)
	@PostMapping
	public ResponseEntity<String> insertMember(@RequestBody Member mem){
		logger.debug("insertMember ----");
		if(memService.insertMember(mem)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "로그인한 id와 일치하는 사용자 정보를 수정한다. 성공시 success, 실패시 fail 리턴 (문자열)", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> modifyBook(@RequestBody Member mem) {
		logger.debug("modifyBook - 호출");
		logger.debug("" + mem);
		if(memService.update(mem)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "로그인", response = String.class)
	@PostMapping("{id}")
	public ResponseEntity<String> login(@RequestBody Member mem) throws SQLException, JsonProcessingException {
	
		logger.debug("login - 호출");
		String id = mem.getId();
		String pwd = mem.getPwd();
		//logger.debug("" + id +" "+pwd);
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pwd);
		//System.out.println(id);
		//System.out.println(pwd);
		//System.out.println("result"+" "+ memService.login(map));
		try {
			Member result = memService.login(map);
			if(result!=null) {
				ObjectMapper objectMapper = new ObjectMapper();
				//System.out.println(objectMapper.writeValueAsString(result));
				String str =objectMapper.writeValueAsString(result);
				System.out.println(str);
				return new ResponseEntity<String>(str, HttpStatus.OK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
