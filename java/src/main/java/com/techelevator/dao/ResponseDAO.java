package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Favorites;
import com.techelevator.model.Picture;

public interface ResponseDAO {
	List<Picture> userPic(int userId);
	List<Picture> userFav(int userId, int favoriteID);
	List<Picture> home();
	List<Favorites> getFavoriteList(int userId);
	

}
