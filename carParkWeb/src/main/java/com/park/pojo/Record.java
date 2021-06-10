/**  

* @Title: Record.java  

* @Package com.carsystem.model  

* @Description: TODO(用一句话描述该文件做什么)  

* @author Administrator  

* @date 2020年2月3日   

*/  
package com.park.pojo;

/**  

* @ClassName: Record  

* @Description: TODO(这里用一句话描述这个类的作用)  

* @author Administrator  

* @date 2020年2月3日  
  

*/
public class Record {
	private Integer id;    		//id
	private String parkName;//停车场名字
	private String location;//停车场位
	private String userName;//用户名
	private String inTime;//进入时间
	private String outTime;//出去时间
	private String isCharge;//是否结算
	private String charge;//消费
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getIsCharge() {
		return isCharge;
	}
	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
}
