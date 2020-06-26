package com.hikvision.boot.commonaction.test;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/6/19 22:02
 * @modify by
 */
public class TestDataInModel {
    private String testTestName;

    public TestDataInModel(int count) {
        testTestName = "name" + String.valueOf(count);
    }

    public String getTestTestName() {
        return testTestName;
    }



    public void setTestTestName(String testTestName) {
        this.testTestName = testTestName;
    }
}
