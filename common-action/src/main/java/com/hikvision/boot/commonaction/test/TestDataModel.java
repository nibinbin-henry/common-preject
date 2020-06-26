package com.hikvision.boot.commonaction.test;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/6/19 20:52
 * @modify by
 */
public class TestDataModel {
    private Integer age;
    private boolean married;
    private TestDataInModel testDataInModel;
    private int[] array = new int[1];

    public TestDataModel(int age, boolean married) {
        this.age = age;
        this.married = married;
        this.testDataInModel = new TestDataInModel(age);
        array[0] = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public TestDataInModel getTestDataInModel() {
        return testDataInModel;
    }

    public void setTestDataInModel(TestDataInModel testDataInModel) {
        this.testDataInModel = testDataInModel;
    }

    public int[] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
}
