package com.usian.controller;

import com.usian.dto.AddTs;
import com.usian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

@Autowired
    private StudentService studentService;

@PostMapping("/insert")
    public void insert(@RequestBody AddTs addTs){
      studentService.add(addTs);
}
}
