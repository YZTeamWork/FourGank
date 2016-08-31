package com.yibh.fourgank.yonionyy.javabean;

/**
 * Created by yibh on 2016/8/31  11:29.
 */

public class TestBean {
    public String mName;
    public String mSex;
    public int mId;

    public TestBean(String name, String sex, int id) {
        mName = name;
        mSex = sex;
        mId = id;
    }

    @Override
    public String toString() {
        return mName+mSex+mId;
    }
}
