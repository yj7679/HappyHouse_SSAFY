package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.SynchronossPartHttpMessageReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
@RequestMapping("/houseController")
public class HouseController {

	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private HouseService houseService;
	
	// 동 검색
	@RequestMapping(value="/searchDong.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String searchDong(@RequestParam("dong") String dong, Model model) {
		List<HouseDeal> hdList = houseService.searchDong(dong);
		model.addAttribute("aptList", hdList);

		return "houseDealInfo";
	}
	
	//아파트 이름 검색
	@RequestMapping(value="/searchAptName.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String searchAptName(@RequestParam("aptName") String aptName, Model model) {
		List<HouseDeal> hdList = houseService.searchAptName(aptName);
		model.addAttribute("aptList", hdList);
		
		return "houseDealInfo";
	}
	
	// 아파트 거래내역 창으로 넘어가는 것
	@RequestMapping(value="/houseDealInfo.do", method= {RequestMethod.POST,RequestMethod.GET})
	public String houseDealInfo() {
		return "houseDealInfo";
	}
}
