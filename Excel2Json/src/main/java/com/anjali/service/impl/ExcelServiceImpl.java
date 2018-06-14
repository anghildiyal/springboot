package com.anjali.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.anjali.domain.ExcelPojo;
import com.anjali.service.ExcelService;
import com.convertor.util.ConvertorUtility.ConverterUtility;

@Service
public class ExcelServiceImpl implements ExcelService {

	public List<ExcelPojo> getJson(String excelPath) {
		// Initialize the list
		List<ExcelPojo> excelList = new ArrayList<ExcelPojo>();
		try (InputStream inputStream = ExcelServiceImpl.class.getClassLoader().getResourceAsStream(excelPath);
				Workbook workbook = new XSSFWorkbook(inputStream)) {

			Sheet sheet = workbook.getSheetAt(0);

			List<Row> listRow = IteratorUtils.toList(sheet.iterator());
					
			// Get Header Map
			HashMap< String,Integer> headerMap=new HashMap<>();
			final AtomicInteger atomicInteger = new AtomicInteger(0);
			List<Cell> headerList = IteratorUtils.toList(listRow.get(0).iterator());
			headerList.stream().forEach(s -> {
				headerMap.put( s.getStringCellValue().trim(),atomicInteger.intValue());
				atomicInteger.getAndIncrement();
			});
			
			// Skip header row
			listRow.remove(0);
			listRow.stream().forEach(s -> {
				ExcelPojo excelPojo = new ExcelPojo();
				excelPojo.setCorpEndCode(Arrays.asList(s.getCell(headerMap.get("CorpEnd Date")).getStringCellValue().split(",")));
				excelPojo.setSpecializeCd(Arrays.asList(s.getCell(3).getStringCellValue().split(",")));
				excelPojo.setProviderType(s.getCell(0).getStringCellValue());
				excelPojo.setUnSolicatedInd(s.getCell(1).getStringCellValue());
				excelList.add(excelPojo);
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return excelList;
	}
}
