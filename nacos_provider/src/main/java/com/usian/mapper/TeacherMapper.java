package com.usian.mapper;

import com.usian.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper extends tk.mybatis.mapper.common.Mapper<Teacher> {

}
