package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ResponseDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Favorites;
import com.techelevator.model.Picture;


@RestController
@CrossOrigin
public class ResponseController {

	private ResponseDAO responseDAO;
	private UserDAO userDAO;

	public ResponseController(ResponseDAO responseDAO, UserDAO userDAO) {
		this.responseDAO = responseDAO;
		this.userDAO = userDAO;
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	public List<Picture> userPictures(Principal principal) {
		int userID = userDAO.findIdByUsername(principal.getName());
		return responseDAO.userPic(userID);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/photos/{favoriteID}", method = RequestMethod.GET)
	public List<Picture> favorites(@PathVariable int favoriteID, Principal principal) {
		int userID = userDAO.findIdByUsername(principal.getName());
		return responseDAO.userFav(userID, favoriteID);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Picture> home() {
		return responseDAO.home();
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/favList", method = RequestMethod.GET)
	public List<Favorites> getFavoriteList(Principal principal) {
		int userID = userDAO.findIdByUsername(principal.getName());
		return responseDAO.getFavoriteList(userID);
	}

}
