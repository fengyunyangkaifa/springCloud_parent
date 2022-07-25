package com.usian.service.impl;

import com.usian.dto.AddTs;
import com.usian.mapper.StudentMapper;
import com.usian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

@Autowired
private StudentMapper studentMapper;
    @Override
    public void add(AddTs addTs) {
//        添加学生
        studentMapper.addStudent(addTs.getStudentList(),addTs.getTeacher().getId());
    }
}
