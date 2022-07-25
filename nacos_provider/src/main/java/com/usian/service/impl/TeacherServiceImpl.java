package com.usian.service.impl;

import com.usian.dto.AddTs;
import com.usian.mapper.TeacherMapper;
import com.usian.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void insert(AddTs addTs) {
//        添加老师
        teacherMapper.insert(addTs.getTeacher());
    }
}
