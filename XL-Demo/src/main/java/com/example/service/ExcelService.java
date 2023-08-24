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
    	 System.out.println("=> " + sheet.getSheetName());
//        DataFormatter dataFormatter = new DataFormatter();
//        Iterator<Row> rowIterator = sheet.rowIterator();
 
//         while (rowIterator.hasNext()) {
//             Row row = rowIterator.next();
//             // Now let's iterate over the columns of the current row
//             Iterator<Cell> cellIterator = row.cellIterator();
//             while (cellIterator.hasNext()) {
//                 Cell cell = cellIterator.next();
//                 String cellValue = dataFormatter.formatCellValue(cell);
//                 System.out.print(cellValue + "\t");
//             }
//             System.out.println();
//         }
         
    	
         XlEntity xl = new XlEntity();
         for(int i =1;i<sheet.getLastRowNum()+1;i++) {
        	 xl.setFirst_name(sheet.getRow(i).getCell(1).toString());
        	 xl.setLast_name(sheet.getRow(i).getCell(2).toString());
        	 xl.setId((int)sheet.getRow(i).getCell(0).getNumericCellValue());
        	 xlRepo.save(xl);
         }

    	return "Successfully inserted";
    }
}