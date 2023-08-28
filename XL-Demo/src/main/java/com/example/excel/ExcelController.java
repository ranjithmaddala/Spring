package com.example.excel;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.XlDTO;
import com.example.entity.XlEntity;
import com.example.service.ExcelService;


@RestController
@RequestMapping("/file")
public class ExcelController {
	@Autowired
    private ExcelService service;

    @PostMapping("/upload")
    public String upload(
            @RequestParam MultipartFile file,
            @RequestParam Integer numberOfSheet)
            throws Exception {
        return service.upload(file, numberOfSheet);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<XlEntity>> getAllsUsers(){
    	List<XlEntity> entities = service.getAllUsers();
    	return new ResponseEntity<List<XlEntity>>(entities, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
    	return service.deleteUser(id);
    }
}