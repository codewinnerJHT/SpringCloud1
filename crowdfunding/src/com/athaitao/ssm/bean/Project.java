package com.athaitao.ssm.bean;

public class Project {
	private Integer id;
	private String name;
	private String information;
	private String briefintroduction;
	private Double money;
	private Integer day;
	private Integer daysremaining;
	private String status;
	private Double supportmoney;
	private Integer userid;
	private String imageurl;
	private Integer hot;
	private String price;
	private String phone;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getBriefintroduction() {
		return briefintroduction;
	}
	public void setBriefintroduction(String briefintroduction) {
		this.briefintroduction = briefintroduction;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getDaysremaining() {
		return daysremaining;
	}
	public void setDaysremaining(Integer daysremaining) {
		this.daysremaining = daysremaining;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getSupportmoney() {
		return supportmoney;
	}
	public void setSupportmoney(Double supportmoney) {
		this.supportmoney = supportmoney;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", information=" + information + ", briefintroduction="
				+ briefintroduction + ", money=" + money + ", day=" + day + ", daysremaining=" + daysremaining
				+ ", status=" + status + ", supportmoney=" + supportmoney + ", userid=" + userid + ", imageurl="
				+ imageurl + ", hot=" + hot + "]";
	}
	
	
	
}
