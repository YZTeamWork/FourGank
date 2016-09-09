package com.yibh.fourgank.yonionyy.retrofit;

/**
 * Created by yibh on 2016/9/7  17:00 .
 */

public class TTTBean {

    /**
     * id :
     * serviceId : 1000
     * type : service
     * time : 1455588106089
     * remark :
     * vin : AAAAAAAA
     * deviceid : AAAAAAAA
     * body : {"area":"北京"}
     */

    private String id;
    private String serviceId;
    private String type;
    private String time;
    private String remark;
    private String vin;
    private String deviceid;
    /**
     * area : 北京
     */

    private BodyBean body;

    public TTTBean(String id, String serviceId, String type, String time, String remark, String vin, String deviceid, BodyBean body) {
        this.id = id;
        this.serviceId = serviceId;
        this.type = type;
        this.time = time;
        this.remark = remark;
        this.vin = vin;
        this.deviceid = deviceid;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        private String area;

        public BodyBean(String area) {
            this.area = area;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
