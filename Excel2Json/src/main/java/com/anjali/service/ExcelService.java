package com.anjali.service;

import java.util.List;

import com.anjali.domain.ExcelPojo;


public interface ExcelService {
	
	public abstract List<ExcelPojo> getJson(String excelPath) ;

}
