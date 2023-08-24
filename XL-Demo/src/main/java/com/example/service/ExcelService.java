package com.example.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.XlEntity;
import com.example.repository.XlEntityRepository;

import java.io.IOException;
import java.util.Iterator;

@Service
public class ExcelService {
	
	@Autowired
	private XlEntityRepository xlRepo;
	
    public String upload(MultipartFile file, Integer numberOfSheet) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        if (numberOfSheet == null || numberOfSheet < 0) {
            numberOfSheet = workbook.getNumberOfSheets();
        }
        for (int i = 0; i < numberOfSheet; i++) {
            // Getting the Sheet at index i
            Sheet sheet = workbook.getSheetAt(i);
           addUsers(sheet);
        }
        return "OK";
    }
    
    public String addUsers(Sheet sheet) {
    	
         XlEntity xl = new XlEntity();
         for(int i =1;i<sheet.getLastRowNum()+1;i++) {
        	 xl.setFirst_name(sheet.getRow(i).getCell(1).toString());
        	  if(sheet.getRow(i).getCell(2) == null)
        		 xl.setLast_name(null);
        	 else
        		 xl.setLast_name(sheet.getRow(i).getCell(2).toString());
        	 xl.setId((int)sheet.getRow(i).getCell(0).getNumericCellValue());
        	 xlRepo.save(xl);
         }

    	return "Successfully inserted";
    }
}
