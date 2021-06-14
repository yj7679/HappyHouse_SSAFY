package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;

public interface HouseService {
	public List<HouseDeal> searchAll();
	public List<HouseDeal> searchDong(String dong);
	public HouseDeal search(int no);
	public List<HouseDeal> searchAptName(String aptName);
}
