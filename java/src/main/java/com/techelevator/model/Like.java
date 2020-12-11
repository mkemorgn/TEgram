package com.techelevator.model;

public class Like {
	
	private int pictureId;
	private int likeId;
	private int userId;
	private String userName;
	
	public Like(int pictureId, int likeId, int userId, String userName) {
	
		this.pictureId = pictureId;
		this.likeId = likeId;
		this.userId = userId;
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
