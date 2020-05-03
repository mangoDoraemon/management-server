package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNull() {
            addCriterion("subject_name is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNotNull() {
            addCriterion("subject_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEqualTo(String value) {
            addCriterion("subject_name =", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotEqualTo(String value) {
            addCriterion("subject_name <>", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThan(String value) {
            addCriterion("subject_name >", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("subject_name >=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThan(String value) {
            addCriterion("subject_name <", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThanOrEqualTo(String value) {
            addCriterion("subject_name <=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLike(String value) {
            addCriterion("subject_name like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotLike(String value) {
            addCriterion("subject_name not like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIn(List<String> values) {
            addCriterion("subject_name in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotIn(List<String> values) {
            addCriterion("subject_name not in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameBetween(String value1, String value2) {
            addCriterion("subject_name between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotBetween(String value1, String value2) {
            addCriterion("subject_name not between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleIsNull() {
            addCriterion("release_people is null");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleIsNotNull() {
            addCriterion("release_people is not null");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleEqualTo(String value) {
            addCriterion("release_people =", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleNotEqualTo(String value) {
            addCriterion("release_people <>", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleGreaterThan(String value) {
            addCriterion("release_people >", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("release_people >=", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleLessThan(String value) {
            addCriterion("release_people <", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleLessThanOrEqualTo(String value) {
            addCriterion("release_people <=", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleLike(String value) {
            addCriterion("release_people like", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleNotLike(String value) {
            addCriterion("release_people not like", value, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleIn(List<String> values) {
            addCriterion("release_people in", values, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleNotIn(List<String> values) {
            addCriterion("release_people not in", values, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleBetween(String value1, String value2) {
            addCriterion("release_people between", value1, value2, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andReleasePeopleNotBetween(String value1, String value2) {
            addCriterion("release_people not between", value1, value2, "releasePeople");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(String value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(String value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(String value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(String value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(String value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(String value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLike(String value) {
            addCriterion("college_id like", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotLike(String value) {
            addCriterion("college_id not like", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<String> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<String> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(String value1, String value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(String value1, String value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andSubjectContentIsNull() {
            addCriterion("subject_content is null");
            return (Criteria) this;
        }

        public Criteria andSubjectContentIsNotNull() {
            addCriterion("subject_content is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectContentEqualTo(String value) {
            addCriterion("subject_content =", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotEqualTo(String value) {
            addCriterion("subject_content <>", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentGreaterThan(String value) {
            addCriterion("subject_content >", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentGreaterThanOrEqualTo(String value) {
            addCriterion("subject_content >=", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentLessThan(String value) {
            addCriterion("subject_content <", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentLessThanOrEqualTo(String value) {
            addCriterion("subject_content <=", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentLike(String value) {
            addCriterion("subject_content like", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotLike(String value) {
            addCriterion("subject_content not like", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentIn(List<String> values) {
            addCriterion("subject_content in", values, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotIn(List<String> values) {
            addCriterion("subject_content not in", values, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentBetween(String value1, String value2) {
            addCriterion("subject_content between", value1, value2, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotBetween(String value1, String value2) {
            addCriterion("subject_content not between", value1, value2, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberIsNull() {
            addCriterion("subject_number is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberIsNotNull() {
            addCriterion("subject_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberEqualTo(Integer value) {
            addCriterion("subject_number =", value, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberNotEqualTo(Integer value) {
            addCriterion("subject_number <>", value, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberGreaterThan(Integer value) {
            addCriterion("subject_number >", value, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_number >=", value, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberLessThan(Integer value) {
            addCriterion("subject_number <", value, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberLessThanOrEqualTo(Integer value) {
            addCriterion("subject_number <=", value, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberIn(List<Integer> values) {
            addCriterion("subject_number in", values, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberNotIn(List<Integer> values) {
            addCriterion("subject_number not in", values, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberBetween(Integer value1, Integer value2) {
            addCriterion("subject_number between", value1, value2, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_number not between", value1, value2, "subjectNumber");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("subject_type is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(String value) {
            addCriterion("subject_type =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(String value) {
            addCriterion("subject_type <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(String value) {
            addCriterion("subject_type >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("subject_type >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(String value) {
            addCriterion("subject_type <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(String value) {
            addCriterion("subject_type <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLike(String value) {
            addCriterion("subject_type like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotLike(String value) {
            addCriterion("subject_type not like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<String> values) {
            addCriterion("subject_type in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<String> values) {
            addCriterion("subject_type not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(String value1, String value2) {
            addCriterion("subject_type between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(String value1, String value2) {
            addCriterion("subject_type not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andManageTimeIsNull() {
            addCriterion("manage_time is null");
            return (Criteria) this;
        }

        public Criteria andManageTimeIsNotNull() {
            addCriterion("manage_time is not null");
            return (Criteria) this;
        }

        public Criteria andManageTimeEqualTo(String value) {
            addCriterion("manage_time =", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotEqualTo(String value) {
            addCriterion("manage_time <>", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeGreaterThan(String value) {
            addCriterion("manage_time >", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeGreaterThanOrEqualTo(String value) {
            addCriterion("manage_time >=", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLessThan(String value) {
            addCriterion("manage_time <", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLessThanOrEqualTo(String value) {
            addCriterion("manage_time <=", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLike(String value) {
            addCriterion("manage_time like", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotLike(String value) {
            addCriterion("manage_time not like", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeIn(List<String> values) {
            addCriterion("manage_time in", values, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotIn(List<String> values) {
            addCriterion("manage_time not in", values, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeBetween(String value1, String value2) {
            addCriterion("manage_time between", value1, value2, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotBetween(String value1, String value2) {
            addCriterion("manage_time not between", value1, value2, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageUserIsNull() {
            addCriterion("manage_user is null");
            return (Criteria) this;
        }

        public Criteria andManageUserIsNotNull() {
            addCriterion("manage_user is not null");
            return (Criteria) this;
        }

        public Criteria andManageUserEqualTo(String value) {
            addCriterion("manage_user =", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserNotEqualTo(String value) {
            addCriterion("manage_user <>", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserGreaterThan(String value) {
            addCriterion("manage_user >", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserGreaterThanOrEqualTo(String value) {
            addCriterion("manage_user >=", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserLessThan(String value) {
            addCriterion("manage_user <", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserLessThanOrEqualTo(String value) {
            addCriterion("manage_user <=", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserLike(String value) {
            addCriterion("manage_user like", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserNotLike(String value) {
            addCriterion("manage_user not like", value, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserIn(List<String> values) {
            addCriterion("manage_user in", values, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserNotIn(List<String> values) {
            addCriterion("manage_user not in", values, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserBetween(String value1, String value2) {
            addCriterion("manage_user between", value1, value2, "manageUser");
            return (Criteria) this;
        }

        public Criteria andManageUserNotBetween(String value1, String value2) {
            addCriterion("manage_user not between", value1, value2, "manageUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}