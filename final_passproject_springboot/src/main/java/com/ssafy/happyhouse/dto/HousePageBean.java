package com.ssafy.happyhouse.dto;

import java.util.Arrays;

public class HousePageBean {
	String city;
	String dong;
	String dongcode;
	String aptName;
	String dealtype;
	boolean[] searchType;
	String pagelink;
	int pageNo;
	int interval;
	int start;
	int end;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptname(String aptName) {
		this.aptName = aptName;
	}
	public String getDealtype() {
		return dealtype;
	}
	public void setDealtype(String dealtype) {
		this.dealtype = dealtype;
	}
	public boolean[] getSearchType() {
		return searchType;
	}
	public void setSearchType(boolean[] searchType) {
		this.searchType = searchType;
	}
	public String getPagelink() {
		return pagelink;
	}
	public void setPagelink(String pagelink) {
		this.pagelink = pagelink;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "HousePageBean [city=" + city + ", dong=" + dong + ", dongcode=" + dongcode + ", apartname=" + aptName
				+ ", dealtype=" + dealtype + ", searchType=" + Arrays.toString(searchType) + ", pagelink=" + pagelink
				+ ", pageNo=" + pageNo + ", interval=" + interval + ", start=" + start + ", end=" + end + "]";
	}
	
}
