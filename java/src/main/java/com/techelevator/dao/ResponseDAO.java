package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Picture;

public interface ResponseDAO {
	List<Picture> userPic();
	List<Picture> userFav();
	List<Picture> home();
	

}
