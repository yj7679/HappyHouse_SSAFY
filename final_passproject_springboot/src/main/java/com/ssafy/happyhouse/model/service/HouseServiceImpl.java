package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ssafy.happyhouse.model.dao.HouseDaoImpl;
import com.ssafy.happyhouse.model.repo.HouseMapper;
import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;

@Service
public class HouseServiceImpl implements HouseService{
	
	private static final Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<HouseDeal> searchAll() {
		return sqlSession.getMapper(HouseMapper.class).searchAll();
	}

	@Override
	public HouseDeal search(int no) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapper.class).search(no);
	}

	@Override
	public List<HouseDeal> searchDong(String dong) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapper.class).searchDong(dong);
	}
	
	@Override
	public List<HouseDeal> searchAptName(String aptName) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapper.class).searchAptName(aptName);
	}

}
