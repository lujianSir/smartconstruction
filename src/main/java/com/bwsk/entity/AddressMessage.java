package com.bwsk.entity;

import java.io.Serializable;

public class AddressMessage implements Serializable {

    private int amid;//地址的ID

    private String amname;//地址的名称

    private int amrange;//地址的范围

    private String amdetail;//地址的详细位置

    private String amlatitude;//经度

    private String amlongitude;//纬度

    public int getAmid() {
        return amid;
    }

    public void setAmid(int amid) {
        this.amid = amid;
    }

    public String getAmname() {
        return amname;
    }

    public void setAmname(String amname) {
        this.amname = amname;
    }

    public int getAmrange() {
        return amrange;
    }

    public void setAmrange(int amrange) {
        this.amrange = amrange;
    }

    public String getAmdetail() {
        return amdetail;
    }

    public void setAmdetail(String amdetail) {
        this.amdetail = amdetail;
    }

    public String getAmlatitude() {
        return amlatitude;
    }

    public void setAmlatitude(String amlatitude) {
        this.amlatitude = amlatitude;
    }

    public String getAmlongitude() {
        return amlongitude;
    }

    public void setAmlongitude(String amlongitude) {
        this.amlongitude = amlongitude;
    }

}
