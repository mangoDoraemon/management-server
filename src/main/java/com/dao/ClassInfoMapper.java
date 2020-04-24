package com.dao;

import com.entity.ClassInfo;
import com.entity.ClassInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassInfoMapper {
    int countByExample(ClassInfoExample example);

    int deleteByExample(ClassInfoExample example);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    List<ClassInfo> selectByExample(ClassInfoExample example);

    int updateByExampleSelective(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    int updateByExample(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    List<ClassInfo> selectClassInfoAll(ClassInfo classInfo);

    List<ClassInfo> getClassInfoDict(String id);

    List<ClassInfo> selectClassNameByTeacherNumber(String teacherNumber);
}