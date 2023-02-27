package spring.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.training.helper.ExcelHelper;
import spring.training.service.BankService;
import spring.training.service.impl.StudentService;

import java.io.IOException;


@RestController
@RequestMapping("files")
public class BankController {
    @Autowired
    private BankService bankService;

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public void saveDatas(@RequestParam("file")MultipartFile file){
       //System.out.println( file.getContentType());
        if (ExcelHelper.hasExcelFormat(file)){
            //studentService.save(file);
            studentService.save(file);

        }

    }

}
