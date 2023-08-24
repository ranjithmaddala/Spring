package com.example.excel;

import com.example.service.ExcelService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class ExcelController {
    private final ExcelService service;

    public ExcelController(ExcelService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public String upload(
            @RequestParam MultipartFile file,
            @RequestParam Integer numberOfSheet)
            throws Exception {
        return service.upload(file, numberOfSheet);
    }
}