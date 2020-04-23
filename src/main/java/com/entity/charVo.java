package com.entity;

import javax.persistence.Transient;
import java.util.List;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/22 23:53
 */
public class charVo {

    private List<String> expectedData;


    private List<Integer> actualData;

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
