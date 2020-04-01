package com.entity;

import java.util.ArrayList;
import java.util.List;

public class CollegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollegeExample() {
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

        public Criteria andCollegeCodeIsNull() {
            addCriterion("college_code is null");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeIsNotNull() {
            addCriterion("college_code is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeEqualTo(String value) {
            addCriterion("college_code =", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeNotEqualTo(String value) {
            addCriterion("college_code <>", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeGreaterThan(String value) {
            addCriterion("college_code >", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("college_code >=", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeLessThan(String value) {
            addCriterion("college_code <", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeLessThanOrEqualTo(String value) {
            addCriterion("college_code <=", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeLike(String value) {
            addCriterion("college_code like", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeNotLike(String value) {
            addCriterion("college_code not like", value, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeIn(List<String> values) {
            addCriterion("college_code in", values, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeNotIn(List<String> values) {
            addCriterion("college_code not in", values, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeBetween(String value1, String value2) {
            addCriterion("college_code between", value1, value2, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeCodeNotBetween(String value1, String value2) {
            addCriterion("college_code not between", value1, value2, "collegeCode");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNull() {
            addCriterion("college_name is null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNotNull() {
            addCriterion("college_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameEqualTo(String value) {
            addCriterion("college_name =", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotEqualTo(String value) {
            addCriterion("college_name <>", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThan(String value) {
            addCriterion("college_name >", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("college_name >=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThan(String value) {
            addCriterion("college_name <", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThanOrEqualTo(String value) {
            addCriterion("college_name <=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLike(String value) {
            addCriterion("college_name like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotLike(String value) {
            addCriterion("college_name not like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIn(List<String> values) {
            addCriterion("college_name in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotIn(List<String> values) {
            addCriterion("college_name not in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameBetween(String value1, String value2) {
            addCriterion("college_name between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotBetween(String value1, String value2) {
            addCriterion("college_name not between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberIsNull() {
            addCriterion("college_number is null");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberIsNotNull() {
            addCriterion("college_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberEqualTo(Integer value) {
            addCriterion("college_number =", value, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberNotEqualTo(Integer value) {
            addCriterion("college_number <>", value, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberGreaterThan(Integer value) {
            addCriterion("college_number >", value, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("college_number >=", value, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberLessThan(Integer value) {
            addCriterion("college_number <", value, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("college_number <=", value, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberIn(List<Integer> values) {
            addCriterion("college_number in", values, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberNotIn(List<Integer> values) {
            addCriterion("college_number not in", values, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberBetween(Integer value1, Integer value2) {
            addCriterion("college_number between", value1, value2, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("college_number not between", value1, value2, "collegeNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceIsNull() {
            addCriterion("college_introduce is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceIsNotNull() {
            addCriterion("college_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceEqualTo(String value) {
            addCriterion("college_introduce =", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceNotEqualTo(String value) {
            addCriterion("college_introduce <>", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceGreaterThan(String value) {
            addCriterion("college_introduce >", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("college_introduce >=", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceLessThan(String value) {
            addCriterion("college_introduce <", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceLessThanOrEqualTo(String value) {
            addCriterion("college_introduce <=", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceLike(String value) {
            addCriterion("college_introduce like", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceNotLike(String value) {
            addCriterion("college_introduce not like", value, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceIn(List<String> values) {
            addCriterion("college_introduce in", values, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceNotIn(List<String> values) {
            addCriterion("college_introduce not in", values, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceBetween(String value1, String value2) {
            addCriterion("college_introduce between", value1, value2, "collegeIntroduce");
            return (Criteria) this;
        }

        public Criteria andCollegeIntroduceNotBetween(String value1, String value2) {
            addCriterion("college_introduce not between", value1, value2, "collegeIntroduce");
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

        public Criteria andCollegeDeanIsNull() {
            addCriterion("college_dean is null");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanIsNotNull() {
            addCriterion("college_dean is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanEqualTo(String value) {
            addCriterion("college_dean =", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanNotEqualTo(String value) {
            addCriterion("college_dean <>", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanGreaterThan(String value) {
            addCriterion("college_dean >", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanGreaterThanOrEqualTo(String value) {
            addCriterion("college_dean >=", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanLessThan(String value) {
            addCriterion("college_dean <", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanLessThanOrEqualTo(String value) {
            addCriterion("college_dean <=", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanLike(String value) {
            addCriterion("college_dean like", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanNotLike(String value) {
            addCriterion("college_dean not like", value, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanIn(List<String> values) {
            addCriterion("college_dean in", values, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanNotIn(List<String> values) {
            addCriterion("college_dean not in", values, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanBetween(String value1, String value2) {
            addCriterion("college_dean between", value1, value2, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeDeanNotBetween(String value1, String value2) {
            addCriterion("college_dean not between", value1, value2, "collegeDean");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailIsNull() {
            addCriterion("college_email is null");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailIsNotNull() {
            addCriterion("college_email is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailEqualTo(String value) {
            addCriterion("college_email =", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailNotEqualTo(String value) {
            addCriterion("college_email <>", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailGreaterThan(String value) {
            addCriterion("college_email >", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailGreaterThanOrEqualTo(String value) {
            addCriterion("college_email >=", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailLessThan(String value) {
            addCriterion("college_email <", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailLessThanOrEqualTo(String value) {
            addCriterion("college_email <=", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailLike(String value) {
            addCriterion("college_email like", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailNotLike(String value) {
            addCriterion("college_email not like", value, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailIn(List<String> values) {
            addCriterion("college_email in", values, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailNotIn(List<String> values) {
            addCriterion("college_email not in", values, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailBetween(String value1, String value2) {
            addCriterion("college_email between", value1, value2, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegeEmailNotBetween(String value1, String value2) {
            addCriterion("college_email not between", value1, value2, "collegeEmail");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneIsNull() {
            addCriterion("college_phone is null");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneIsNotNull() {
            addCriterion("college_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneEqualTo(String value) {
            addCriterion("college_phone =", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneNotEqualTo(String value) {
            addCriterion("college_phone <>", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneGreaterThan(String value) {
            addCriterion("college_phone >", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("college_phone >=", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneLessThan(String value) {
            addCriterion("college_phone <", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneLessThanOrEqualTo(String value) {
            addCriterion("college_phone <=", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneLike(String value) {
            addCriterion("college_phone like", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneNotLike(String value) {
            addCriterion("college_phone not like", value, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneIn(List<String> values) {
            addCriterion("college_phone in", values, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneNotIn(List<String> values) {
            addCriterion("college_phone not in", values, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneBetween(String value1, String value2) {
            addCriterion("college_phone between", value1, value2, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegePhoneNotBetween(String value1, String value2) {
            addCriterion("college_phone not between", value1, value2, "collegePhone");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelIsNull() {
            addCriterion("college_level is null");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelIsNotNull() {
            addCriterion("college_level is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelEqualTo(String value) {
            addCriterion("college_level =", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelNotEqualTo(String value) {
            addCriterion("college_level <>", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelGreaterThan(String value) {
            addCriterion("college_level >", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("college_level >=", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelLessThan(String value) {
            addCriterion("college_level <", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelLessThanOrEqualTo(String value) {
            addCriterion("college_level <=", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelLike(String value) {
            addCriterion("college_level like", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelNotLike(String value) {
            addCriterion("college_level not like", value, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelIn(List<String> values) {
            addCriterion("college_level in", values, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelNotIn(List<String> values) {
            addCriterion("college_level not in", values, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelBetween(String value1, String value2) {
            addCriterion("college_level between", value1, value2, "collegeLevel");
            return (Criteria) this;
        }

        public Criteria andCollegeLevelNotBetween(String value1, String value2) {
            addCriterion("college_level not between", value1, value2, "collegeLevel");
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