package com.techelevator.model;

public class Rating {
	
	private int ratingId;
	private int pictureId;
	private int userId;
	private double rating;
	
	public Rating(int ratingId, int pictureId, int userId, double rating) {
		this.ratingId = ratingId;
		this.pictureId = pictureId;
		this.userId = userId;
		this.rating = rating;
	}
	
	
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

}
