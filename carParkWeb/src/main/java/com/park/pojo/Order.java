/**  

* @Title: Record.java  

* @Package com.carsystem.model  

* @Description: TODO(用一句话描述该文件做什么)  

* @author Administrator  

* @date 2020年2月3日   

*/  
package com.park.pojo;


public class Order {
	private Integer id;
	private Integer rentId;
	private String uid;
	private String createTime;//创建时间
	private String charge;//费用
	private String parkName;
	private String rentName;//业主姓名
	private String name;//租户姓名
	private String startTime;
	private String endTime;
	public Integer getId() {
		return id;
	}
	public String  getName() {return name;}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRentId() {
		return rentId;
	}

	public void setRentId(Integer rentId) {
		this.rentId = rentId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getRentName() {
		return rentName;
	}

	public void setRentName(String rentName) {
		this.rentName = rentName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
