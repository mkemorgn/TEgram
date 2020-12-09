package com.techelevator.model;

public class Like {
	
	private int pictureId;
	private int likeId;
	private int userId;
	
	public Like(int pictureId, int likeId, int userId) {
		this.pictureId = pictureId;
		this.likeId = likeId;
		this.userId = userId;
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
