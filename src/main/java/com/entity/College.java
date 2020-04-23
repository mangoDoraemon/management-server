package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "college_info")
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String collegeCode;

    private String collegeName;

    private Integer collegeNumber;

    private String collegeIntroduce;

    private String status;

    private String collegeDean;

    private String collegeEmail;

    private String collegePhone;

    private String collegeLevel;

    private String remark;

    @Transient
    private String fuzzy;

    @Transient
    private Integer teacherTotal;

    @Transient
    private Integer studentTotal;

    @Transient
    private List<String> expectedData;

    @Transient
    private List<Integer> actualData;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode == null ? null : collegeCode.trim();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public Integer getCollegeNumber() {
        return collegeNumber;
    }

    public void setCollegeNumber(Integer collegeNumber) {
        this.collegeNumber = collegeNumber;
    }

    public String getCollegeIntroduce() {
        return collegeIntroduce;
    }

    public void setCollegeIntroduce(String collegeIntroduce) {
        this.collegeIntroduce = collegeIntroduce == null ? null : collegeIntroduce.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCollegeDean() {
        return collegeDean;
    }

    public void setCollegeDean(String collegeDean) {
        this.collegeDean = collegeDean == null ? null : collegeDean.trim();
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail == null ? null : collegeEmail.trim();
    }

    public String getCollegePhone() {
        return collegePhone;
    }

    public void setCollegePhone(String collegePhone) {
        this.collegePhone = collegePhone == null ? null : collegePhone.trim();
    }

    public String getCollegeLevel() {
        return collegeLevel;
    }

    public void setCollegeLevel(String collegeLevel) {
        this.collegeLevel = collegeLevel == null ? null : collegeLevel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(String fuzzy) {
        this.fuzzy = fuzzy;
    }

    public Integer getTeacherTotal() {
        return teacherTotal;
    }

    public void setTeacherTotal(Integer teacherTotal) {
        this.teacherTotal = teacherTotal;
    }

    public Integer getStudentTotal() {
        return studentTotal;
    }

    public void setStudentTotal(Integer studentTotal) {
        this.studentTotal = studentTotal;
    }

    public List<String> getExpectedData() {
        return expectedData;
    }

    public void setExpectedData(List<String> expectedData) {
        this.expectedData = expectedData;
    }


    public List<Integer> getActualData() {
        return actualData;
    }

    public void setActualData(List<Integer> actualData) {
        this.actualData = actualData;
    }
}