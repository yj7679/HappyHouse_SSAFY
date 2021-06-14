package com.ssafy.happyhouse.model.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;

public interface HouseMapper {
	public List<HouseDeal> searchAll();
	public HouseDeal search(int no);
	public List<HouseDeal> searchDong(String dong);
	public List<HouseDeal> searchAptName(String aptName);
}
