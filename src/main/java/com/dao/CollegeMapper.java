package com.dao;

import com.entity.College;
import com.entity.CollegeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    List<College> selectCollegeInfoAll(College college);


    List<College> getCollegeDict();

    List<College> getChartInfo();

    String selectCollegeNameBycode(String collegeId);
}