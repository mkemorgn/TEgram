package com.techelevator.controller;

import java.security.Principal;

import javax.xml.stream.events.Comment;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PicServiceDAO;
import com.techelevator.dao.ResponseDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Like;
import com.techelevator.model.Rating;

@RestController
@CrossOrigin
public class PicServController {
	
	private PicServiceDAO picServiceDAO;
	private UserDAO userDAO;
	
	public PicServController(PicServiceDAO picServiceDAO, UserDAO userDAO) {
		this.picServiceDAO = picServiceDAO;
		this.userDAO = userDAO;
	}
	
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/like/{pictureId}", method = RequestMethod.PUT)
	public Like addLike(@PathVariable int pictureId, Principal principal) {
		int userID = userDAO.findIdByUsername(principal.getName());
		return picServiceDAO.addLike(pictureId);
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/comment/{pictureId}", method = RequestMethod.PUT)
	public Comments addComment(@PathVariable int pictureId, Principal principal) {
		int userID = userDAO.findIdByUsername(principal.getName());
		return picServiceDAO.addComment(pictureId);
		
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/rating/{pictureId}", method = RequestMethod.PUT)
	public Rating addComment(@PathVariable int pictureId, Principal principal) {
		int userID = userDAO.findIdByUsername(principal.getName());
		return picServiceDAO.addRating(pictureId);
		
	}

}
