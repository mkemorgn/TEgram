package com.techelevator.model;

public class Favorite {
	
	private int favoriteId;
	private String favoriteName;
	private int userId;
	
	public Favorite(int favoriteId, String favoriteName, int userId) {
		
		this.favoriteId = favoriteId;
		this.favoriteName = favoriteName;
		this.userId = userId;
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

}
