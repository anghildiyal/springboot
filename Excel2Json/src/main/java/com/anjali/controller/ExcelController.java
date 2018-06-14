package com.anjali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjali.domain.ExcelPojo;
import com.anjali.service.ExcelService;

@RestController
public class ExcelController {
	
	@Autowired
	ExcelService excelSevrice;
	
	@RequestMapping("/pro")
	public List<ExcelPojo> getProviderNetworkJson(){
		List<ExcelPojo> list =excelSevrice.getJson("pnd.xlsx");
		return list;
	}
}
