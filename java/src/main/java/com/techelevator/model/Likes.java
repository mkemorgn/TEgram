package com.techelevator.model;

public class Likes {
	
	private int pictureId;
	private int likeId;
	private int userId;
	private String byUser;
	
	public Likes(int pictureId, int likeId, int userId, String userName) {
	
		this.pictureId = pictureId;
		this.likeId = likeId;
		this.userId = userId;
		this.byUser = userName;
	}
	public String getUserName() {
		return byUser;
	}
	public void setUserName(String userName) {
		this.byUser = userName;
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
