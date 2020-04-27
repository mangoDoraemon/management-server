package com.dao;

import com.entity.TimeLine;
import com.entity.TimeLineExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TimeLineMapper {
    int countByExample(TimeLineExample example);

    int deleteByExample(TimeLineExample example);

    int insert(TimeLine record);

    int insertSelective(TimeLine record);

    List<TimeLine> selectByExample(TimeLineExample example);

    int updateByExampleSelective(@Param("record") TimeLine record, @Param("example") TimeLineExample example);

    int updateByExample(@Param("record") TimeLine record, @Param("example") TimeLineExample example);

    List<TimeLine> selectTimeLineData(String userId);
}