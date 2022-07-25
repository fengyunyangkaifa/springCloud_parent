package com.usian.mapper;

import com.usian.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<Student>{

    void addStudent(List<Student> studentList,@Param("tid") Integer id);
}
