package com.athaitao.ssm.bean;

public class News {
	
	private Integer id;
	private String title;
	private String publisher;
	private String time;
	private String contentone;
	private String contenttwo;
	private String contentthree;
	private String imageurlone;
	private String imageurltwo;
	private String imageurlthree;
	private Integer comment;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContentone() {
		return contentone;
	}
	public void setContentone(String contentone) {
		this.contentone = contentone;
	}
	public String getContenttwo() {
		return contenttwo;
	}
	public void setContenttwo(String contenttwo) {
		this.contenttwo = contenttwo;
	}
	public String getContentthree() {
		return contentthree;
	}
	public void setContentthree(String contentthree) {
		this.contentthree = contentthree;
	}
	public String getImageurlone() {
		return imageurlone;
	}
	public void setImageurlone(String imageurlone) {
		this.imageurlone = imageurlone;
	}
	public String getImageurltwo() {
		return imageurltwo;
	}
	public void setImageurltwo(String imageurltwo) {
		this.imageurltwo = imageurltwo;
	}
	public String getImageurlthree() {
		return imageurlthree;
	}
	public void setImageurlthree(String imageurlthree) {
		this.imageurlthree = imageurlthree;
	}
	public Integer getComment() {
		return comment;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publisher=" + publisher + ", time=" + time + ", contentone="
				+ contentone + ", contenttwo=" + contenttwo + ", contentthree=" + contentthree + ", imageurlone="
				+ imageurlone + ", imageurltwo=" + imageurltwo + ", imageurlthree=" + imageurlthree + ", comment="
				+ comment + ", type=" + type + "]";
	}
	
}
