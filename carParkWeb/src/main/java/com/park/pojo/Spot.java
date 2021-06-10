package com.park.pojo;

//车位表
public class Spot {
    private Integer id;    	//用户id
    private String parkName;//停车场名字
    private String parkLocation;//停车场地址
    private Integer parkNum;//车位号码


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkLocation() {
        return parkLocation;
    }

    public void setParkLocation(String parkLocation) {
        this.parkLocation = parkLocation;
    }

    public Integer getParkNum() {
        return parkNum;
    }

    public void setParkNum(Integer parkNum) {
        this.parkNum = parkNum;
    }
}
