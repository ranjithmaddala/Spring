package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.XlDTO;
import com.example.entity.XlEntity;
import com.example.repository.XlEntityRepository;

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
        return "Successfully inserted";
    }
    
    public String addUsers(Sheet sheet) {
         XlEntity xl = new XlEntity();
         for(int i =1;i<sheet.getLastRowNum()+1;i++) {
        	 xl.setEntityId((int)sheet.getRow(i).getCell(0).getNumericCellValue());
        	 xl.setCustomerId((int)sheet.getRow(i).getCell(1).getNumericCellValue());
        	 xl.setServiceGroupId(sheet.getRow(i).getCell(2).toString());
        	 xl.setServiceIdAccess(sheet.getRow(i).getCell(3).toString());
        	 xl.setServiceIdCatv(sheet.getRow(i).getCell(4).toString());
        	 xl.setServiceIdEquipment(sheet.getRow(i).getCell(5).toString());
        	 xl.setPaid(sheet.getRow(i).getCell(6).toString());
        	 xl.setServiceIdDtv(sheet.getRow(i).getCell(7).toString());
        	 xl.setServiceIdStb(sheet.getRow(i).getCell(8).toString());
        	 xl.setSerialStb(sheet.getRow(i).getCell(9).toString());
        	 xl.setSerialSc(sheet.getRow(i).getCell(10).toString());
        	 xl.setEntitlements(sheet.getRow(i).getCell(11).toString());
        	 xl.setServiceIdInt(sheet.getRow(i).getCell(12).toString());
        	 xl.setServiceIdEmta(sheet.getRow(i).getCell(13).toString());
        	 xl.setSerialEmta(sheet.getRow(i).getCell(14).toString());
        	 xlRepo.save(xl);
         }

    	return "Successfully inserted";
    }
    
    public List<XlEntity> getAllUsers(){
    	List<XlEntity> entities = xlRepo.findAll();
    	
    	return entities;
    }
    
    public String deleteUser(Integer id) {
    	xlRepo.deleteById(id);
    	return "deleted";
    }
}