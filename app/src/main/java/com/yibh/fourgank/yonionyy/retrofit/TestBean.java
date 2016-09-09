package com.yibh.fourgank.yonionyy.retrofit;

/**
 * Created by yibh on 2016/9/7  11:37 .
 */

public class TestBean {
    /**
     * userid : 1
     * action : powerOff
     * runtime : 1
     */

    private int userid;
    private String action;
    private int runtime;

    public TestBean(int userid, String action, int runtime) {
        this.userid = userid;
        this.action = action;
        this.runtime = runtime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    /**
     * Unable to create call adapter for rx.Observable
     */


}
