package com.techelevator.model;

public class Favorites {
	
	private int favoriteId;
	private String favoriteName;
	private int userId;
	private String userName;
	
	public Favorites(int favoriteId, String favoriteName, int userId, String userName) {
		
		this.favoriteId = favoriteId;
		this.favoriteName = favoriteName;
		this.userId = userId;
		this.userName = userName;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public String getFavoriteName() {
		return favoriteName;
	}

	public void setFavoriteName(String favoriteName) {
		this.favoriteName = favoriteName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
