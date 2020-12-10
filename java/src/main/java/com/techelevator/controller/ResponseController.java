package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ResponseDAO;
import com.techelevator.model.Picture;

@RestController
@CrossOrigin
public class ResponseController {
	
	private ResponseDAO responseDAO;
	
	public ResponseController (ResponseDAO responseDAO) {
		this.responseDAO = responseDAO;
	}
	
	@RequestMapping(value = "/photos/{userId}", method = RequestMethod.GET)
	public List<Picture> userpictures(@PathVariable int userId) {
		return responseDAO.userPic(userId);
	}
	
	@RequestMapping(value = "/photos/{userId}/{favoriteID}", method = RequestMethod.GET)
	public List<Picture> favorites(@PathVariable int userId, @PathVariable int favoriteID) {
		return responseDAO.userFav(userId,favoriteID);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Picture> home() {
		return responseDAO.home();
	}
	

}
