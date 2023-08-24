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
    
    public List<XlEntity> getAllUsers(){
    	List<XlEntity> entities = xlRepo.findAll();
    	
    	return entities;
    }
    
    public XlDTO getUserById(Integer id) throws Exception {
    	Optional<XlEntity> entity = xlRepo.findById(id);
    	if(entity.isEmpty())
    		throw new Exception("user not found with id");
    	XlDTO dto = new XlDTO();
    	dto.setFirst_name(entity.get().getFirst_name());
    	dto.setLast_name(entity.get().getLast_name());
    	dto.setId(entity.get().getId());
    	return dto;
    }
    
    public String updateUSer(Integer id, String firstName) {
    	XlEntity xl = new XlEntity();
    	xl.setFirst_name(firstName);
    	xl.setId(id);
    	xl.setLast_name(xl.getLast_name());
    	xlRepo.save(xl);
    	
    	return "successfully updated";
    }
    
    public String deleteUser(Integer id) {
    	xlRepo.deleteById(id);
    	return "deleted";
    }
}