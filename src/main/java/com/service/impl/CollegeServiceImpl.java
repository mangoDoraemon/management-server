package com.service.impl;

import com.constant.CommonConstant;
import com.dao.ClassInfoMapper;
import com.dao.CollegeMapper;
import com.entity.ClassInfo;
import com.entity.ClassInfoExample;
import com.entity.College;
import com.entity.CollegeExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.CollegeService;
import com.util.AjaxResult;
import com.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/21 17:40
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
    CollegeMapper collegeMapper;
    @Resource
    ClassInfoMapper classInfoMapper;


    @Override
    public PageInfo fetchData(Integer page, Integer limit, String fuzzy, String collegeCode, String collegeName) {
        PageHelper.startPage(page,limit);
        College college = new College();
        if(!StringUtils.isEmpty(fuzzy)){
            college.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(collegeCode)){
            college.setCollegeCode(collegeCode);
        }
        if(!StringUtils.isEmpty(collegeName)){
            college.setCollegeName(collegeName);
        }
        List<College> collegeList = collegeMapper.selectCollegeInfoAll(college);
        return new PageInfo<>(collegeList);
    }

    @Override
    public AjaxResult addData(College college) {
        if(college != null){
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andCollegeCodeEqualTo(college.getCollegeCode());
            List<College> collegeList = collegeMapper.selectByExample(collegeExample);
            if(!CollectionUtils.isEmpty(collegeList)){
                return AjaxResult.error("该学院编号已经存在，请核对后再试");
            }
            college.setId(UUID.randomUUID().toString());
            college.setStatus(CommonConstant.STATUS_INIT);
            collegeMapper.insert(college);
            return AjaxResult.success("添加学院信息成功");
        }else {
            return AjaxResult.error("服务器开小差了，请稍后再试");
        }

    }

    @Override
    public AjaxResult updateData(College college) {
        if(college != null){
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andIdNotEqualTo(college.getId()).andCollegeCodeEqualTo(college.getCollegeCode());
            List<College> collegeList = collegeMapper.selectByExample(collegeExample);
            if(!CollectionUtils.isEmpty(collegeList)){
                return AjaxResult.error("学院编号已经存在，请核对");
            }
            CollegeExample collegeExample1=new CollegeExample();
            collegeExample1.createCriteria().andIdEqualTo(college.getId());
            collegeMapper.updateByExample(college,collegeExample1);
            return AjaxResult.success("修改成功");
        }else {
            return AjaxResult.error("修改失败");
        }

    }

    @Override
    public AjaxResult deleteData(String id) {
        if(!StringUtils.isEmpty(id)){
            ClassInfoExample classInfoExample = new ClassInfoExample();
            classInfoExample.createCriteria().andCollegeIdEqualTo(id);
            List<ClassInfo> classInfoList = classInfoMapper.selectByExample(classInfoExample);
            if(!CollectionUtils.isEmpty(classInfoList)){
                return AjaxResult.error("该学院信息已经被使用，不可删除");
            }else {
                CollegeExample collegeExample = new CollegeExample();
                collegeExample.createCriteria().andCollegeCodeEqualTo(id);
                collegeMapper.deleteByExample(collegeExample);
                return AjaxResult.success("删除成功");
            }
        }else {
            return AjaxResult.error("删除失败！");
        }

    }
}
