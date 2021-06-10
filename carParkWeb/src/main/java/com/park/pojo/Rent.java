package com.park.pojo;

/**
 * 描述:发布车位
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/4/22 19:30
 */
public class Rent {
    private Integer id;
    private String parkStartTime;
    private String uid;
    private String parkEndTime;
    private String parkAddress;
    private String parkNum;
    private String parkRentMoney;
    private String parkUserName;
    private String parkPhone;
    private String parkYz;
    private String park_img;

    public Rent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkStartTime() {
        return parkStartTime;
    }

    public void setParkStartTime(String parkStartTime) {
        this.parkStartTime = parkStartTime;
    }

    public String getParkEndTime() {
        return parkEndTime;
    }

    public void setParkEndTime(String parkEndTime) {
        this.parkEndTime = parkEndTime;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    public String getParkNum() {
        return parkNum;
    }

    public void setParkNum(String parkNum) {
        this.parkNum = parkNum;
    }

    public String getParkRentMoney() {
        return parkRentMoney;
    }

    public void setParkRentMoney(String parkRentMoney) {
        this.parkRentMoney = parkRentMoney;
    }

    public String getParkUserName() {
        return parkUserName;
    }

    public void setParkUserName(String parkUserName) {
        this.parkUserName = parkUserName;
    }

    public String getParkPhone() {
        return parkPhone;
    }

    public void setParkPhone(String parkPhone) {
        this.parkPhone = parkPhone;
    }

    public String getParkYz() {
        return parkYz;
    }

    public void setParkYz(String parkYz) {
        this.parkYz = parkYz;
    }

    public String getPark_img() {
        return park_img;
    }

    public void setPark_img(String park_img) {
        this.park_img = park_img;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
