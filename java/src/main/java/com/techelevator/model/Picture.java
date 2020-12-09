package com.techelevator.model;

public class Picture {
	
	private int pictureId;
	private int userId;
	private String picUrl;
	private String picServerName;
	private String picName;
	private String description;
	private boolean isPrivate;
	
//	public Picture(int pictureId, int userId, String picUrl, String picServerName, String picName, String description, boolean isPrivate) {
//		this.pictureId = pictureId;
//		this.userId = userId;
//		this.picUrl = picUrl;
//		this.picServerName = picServerName;
//		this.picName = picName;
//		this.description = description;
//		this.isPrivate = isPrivate;
//	}
	
	
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getPicServerName() {
		return picServerName;
	}
	public void setPicServerName(String picServerName) {
		this.picServerName = picServerName;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPrivate() {
		return isPrivate;
	}
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	
	

	

}
