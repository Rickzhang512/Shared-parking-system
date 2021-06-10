package com.park.pojo;

public class Park {
	private Integer id;    		//用户id
	private String parkName;//停车场名字
	private String parkLocation;//停车场地址
	private int parkNumber;//停车场停车位数量
	private String feeScale;//租金
	private String userInfo;//使用信息

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

	public int getParkNumber() {
		return parkNumber;
	}

	public void setParkNumber(int parkNumber) {
		this.parkNumber = parkNumber;
	}

	public String getFeeScale() {
		return feeScale;
	}

	public void setFeeScale(String feeScale) {
		this.feeScale = feeScale;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
}
