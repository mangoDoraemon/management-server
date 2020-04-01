package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeacherNumberIsNull() {
            addCriterion("teacher_number is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIsNotNull() {
            addCriterion("teacher_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberEqualTo(String value) {
            addCriterion("teacher_number =", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotEqualTo(String value) {
            addCriterion("teacher_number <>", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberGreaterThan(String value) {
            addCriterion("teacher_number >", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_number >=", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLessThan(String value) {
            addCriterion("teacher_number <", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLessThanOrEqualTo(String value) {
            addCriterion("teacher_number <=", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLike(String value) {
            addCriterion("teacher_number like", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotLike(String value) {
            addCriterion("teacher_number not like", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIn(List<String> values) {
            addCriterion("teacher_number in", values, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotIn(List<String> values) {
            addCriterion("teacher_number not in", values, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberBetween(String value1, String value2) {
            addCriterion("teacher_number between", value1, value2, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotBetween(String value1, String value2) {
            addCriterion("teacher_number not between", value1, value2, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNull() {
            addCriterion("teacher_email is null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNotNull() {
            addCriterion("teacher_email is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailEqualTo(String value) {
            addCriterion("teacher_email =", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotEqualTo(String value) {
            addCriterion("teacher_email <>", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThan(String value) {
            addCriterion("teacher_email >", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_email >=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThan(String value) {
            addCriterion("teacher_email <", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThanOrEqualTo(String value) {
            addCriterion("teacher_email <=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLike(String value) {
            addCriterion("teacher_email like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotLike(String value) {
            addCriterion("teacher_email not like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIn(List<String> values) {
            addCriterion("teacher_email in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotIn(List<String> values) {
            addCriterion("teacher_email not in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailBetween(String value1, String value2) {
            addCriterion("teacher_email between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotBetween(String value1, String value2) {
            addCriterion("teacher_email not between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherClassIsNull() {
            addCriterion("teacher_class is null");
            return (Criteria) this;
        }

        public Criteria andTeacherClassIsNotNull() {
            addCriterion("teacher_class is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherClassEqualTo(String value) {
            addCriterion("teacher_class =", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotEqualTo(String value) {
            addCriterion("teacher_class <>", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassGreaterThan(String value) {
            addCriterion("teacher_class >", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_class >=", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassLessThan(String value) {
            addCriterion("teacher_class <", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassLessThanOrEqualTo(String value) {
            addCriterion("teacher_class <=", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassLike(String value) {
            addCriterion("teacher_class like", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotLike(String value) {
            addCriterion("teacher_class not like", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassIn(List<String> values) {
            addCriterion("teacher_class in", values, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotIn(List<String> values) {
            addCriterion("teacher_class not in", values, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassBetween(String value1, String value2) {
            addCriterion("teacher_class between", value1, value2, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotBetween(String value1, String value2) {
            addCriterion("teacher_class not between", value1, value2, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageIsNull() {
            addCriterion("teacher_collage is null");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageIsNotNull() {
            addCriterion("teacher_collage is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageEqualTo(String value) {
            addCriterion("teacher_collage =", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageNotEqualTo(String value) {
            addCriterion("teacher_collage <>", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageGreaterThan(String value) {
            addCriterion("teacher_collage >", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_collage >=", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageLessThan(String value) {
            addCriterion("teacher_collage <", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageLessThanOrEqualTo(String value) {
            addCriterion("teacher_collage <=", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageLike(String value) {
            addCriterion("teacher_collage like", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageNotLike(String value) {
            addCriterion("teacher_collage not like", value, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageIn(List<String> values) {
            addCriterion("teacher_collage in", values, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageNotIn(List<String> values) {
            addCriterion("teacher_collage not in", values, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageBetween(String value1, String value2) {
            addCriterion("teacher_collage between", value1, value2, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherCollageNotBetween(String value1, String value2) {
            addCriterion("teacher_collage not between", value1, value2, "teacherCollage");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIsNull() {
            addCriterion("teacher_position is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIsNotNull() {
            addCriterion("teacher_position is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionEqualTo(String value) {
            addCriterion("teacher_position =", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotEqualTo(String value) {
            addCriterion("teacher_position <>", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionGreaterThan(String value) {
            addCriterion("teacher_position >", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_position >=", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLessThan(String value) {
            addCriterion("teacher_position <", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLessThanOrEqualTo(String value) {
            addCriterion("teacher_position <=", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLike(String value) {
            addCriterion("teacher_position like", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotLike(String value) {
            addCriterion("teacher_position not like", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIn(List<String> values) {
            addCriterion("teacher_position in", values, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotIn(List<String> values) {
            addCriterion("teacher_position not in", values, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionBetween(String value1, String value2) {
            addCriterion("teacher_position between", value1, value2, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotBetween(String value1, String value2) {
            addCriterion("teacher_position not between", value1, value2, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionIsNull() {
            addCriterion("teacher_introduction is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionIsNotNull() {
            addCriterion("teacher_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionEqualTo(String value) {
            addCriterion("teacher_introduction =", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotEqualTo(String value) {
            addCriterion("teacher_introduction <>", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionGreaterThan(String value) {
            addCriterion("teacher_introduction >", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_introduction >=", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionLessThan(String value) {
            addCriterion("teacher_introduction <", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionLessThanOrEqualTo(String value) {
            addCriterion("teacher_introduction <=", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionLike(String value) {
            addCriterion("teacher_introduction like", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotLike(String value) {
            addCriterion("teacher_introduction not like", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionIn(List<String> values) {
            addCriterion("teacher_introduction in", values, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotIn(List<String> values) {
            addCriterion("teacher_introduction not in", values, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionBetween(String value1, String value2) {
            addCriterion("teacher_introduction between", value1, value2, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotBetween(String value1, String value2) {
            addCriterion("teacher_introduction not between", value1, value2, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNull() {
            addCriterion("teacher_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNotNull() {
            addCriterion("teacher_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneEqualTo(String value) {
            addCriterion("teacher_phone =", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotEqualTo(String value) {
            addCriterion("teacher_phone <>", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThan(String value) {
            addCriterion("teacher_phone >", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_phone >=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThan(String value) {
            addCriterion("teacher_phone <", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThanOrEqualTo(String value) {
            addCriterion("teacher_phone <=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLike(String value) {
            addCriterion("teacher_phone like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotLike(String value) {
            addCriterion("teacher_phone not like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIn(List<String> values) {
            addCriterion("teacher_phone in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotIn(List<String> values) {
            addCriterion("teacher_phone not in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneBetween(String value1, String value2) {
            addCriterion("teacher_phone between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotBetween(String value1, String value2) {
            addCriterion("teacher_phone not between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNull() {
            addCriterion("teacher_sex is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNotNull() {
            addCriterion("teacher_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexEqualTo(String value) {
            addCriterion("teacher_sex =", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotEqualTo(String value) {
            addCriterion("teacher_sex <>", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThan(String value) {
            addCriterion("teacher_sex >", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_sex >=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThan(String value) {
            addCriterion("teacher_sex <", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThanOrEqualTo(String value) {
            addCriterion("teacher_sex <=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLike(String value) {
            addCriterion("teacher_sex like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotLike(String value) {
            addCriterion("teacher_sex not like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIn(List<String> values) {
            addCriterion("teacher_sex in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotIn(List<String> values) {
            addCriterion("teacher_sex not in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexBetween(String value1, String value2) {
            addCriterion("teacher_sex between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotBetween(String value1, String value2) {
            addCriterion("teacher_sex not between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIsNull() {
            addCriterion("teacher_title is null");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIsNotNull() {
            addCriterion("teacher_title is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleEqualTo(String value) {
            addCriterion("teacher_title =", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNotEqualTo(String value) {
            addCriterion("teacher_title <>", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleGreaterThan(String value) {
            addCriterion("teacher_title >", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_title >=", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleLessThan(String value) {
            addCriterion("teacher_title <", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleLessThanOrEqualTo(String value) {
            addCriterion("teacher_title <=", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleLike(String value) {
            addCriterion("teacher_title like", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNotLike(String value) {
            addCriterion("teacher_title not like", value, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIn(List<String> values) {
            addCriterion("teacher_title in", values, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNotIn(List<String> values) {
            addCriterion("teacher_title not in", values, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleBetween(String value1, String value2) {
            addCriterion("teacher_title between", value1, value2, "teacherTitle");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNotBetween(String value1, String value2) {
            addCriterion("teacher_title not between", value1, value2, "teacherTitle");
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

        public Criteria andManageTimeIsNull() {
            addCriterion("manage_time is null");
            return (Criteria) this;
        }

        public Criteria andManageTimeIsNotNull() {
            addCriterion("manage_time is not null");
            return (Criteria) this;
        }

        public Criteria andManageTimeEqualTo(Date value) {
            addCriterion("manage_time =", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotEqualTo(Date value) {
            addCriterion("manage_time <>", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeGreaterThan(Date value) {
            addCriterion("manage_time >", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("manage_time >=", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLessThan(Date value) {
            addCriterion("manage_time <", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeLessThanOrEqualTo(Date value) {
            addCriterion("manage_time <=", value, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeIn(List<Date> values) {
            addCriterion("manage_time in", values, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotIn(List<Date> values) {
            addCriterion("manage_time not in", values, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeBetween(Date value1, Date value2) {
            addCriterion("manage_time between", value1, value2, "manageTime");
            return (Criteria) this;
        }

        public Criteria andManageTimeNotBetween(Date value1, Date value2) {
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