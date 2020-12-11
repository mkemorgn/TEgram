package com.techelevator.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PicServiceDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Comments;

import com.techelevator.model.Ratings;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PicServiceController {
	
	private PicServiceDAO picServiceDAO;
	private UserDAO userDAO;
	
	public PicServiceController(PicServiceDAO picServiceDAO, UserDAO userDAO) {
		
		this.picServiceDAO = picServiceDAO;
		this.userDAO = userDAO;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/like/{pictureId}", method = RequestMethod.POST)
	public void  addLike(@PathVariable int pictureId, Principal principal) {
		
		int userId=userDAO.findIdByUsername(principal.getName());
		picServiceDAO.addLike(pictureId, userId);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/rlike/{likeId}", method = RequestMethod.POST)
	public void  removeLike(@PathVariable int likeId) {
		picServiceDAO.removeLike(likeId);
		
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	
	public void addComment(@RequestBody Comments cmnt, Principal principal) {
		
		int userId=userDAO.findIdByUsername(principal.getName());
		picServiceDAO.addComment(cmnt.getPictureId(), userId, cmnt.getComment());
		
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/comment/{commentId}", method = RequestMethod.POST)
	public void removeComment(@PathVariable int commentId) {
		picServiceDAO.removeComment(commentId);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/rate", method = RequestMethod.POST)
	public void addRating(@RequestBody Ratings rating, Principal principal) {
		int userId=userDAO.findIdByUsername(principal.getName());
		picServiceDAO.addRating(rating.getPictureId(), userId, rating.getRating());
		
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value = "/editrate", method = RequestMethod.POST)
	public void changeRating(@RequestBody Ratings rating) {
		
		picServiceDAO.changeRating(rating.getRatingId(), rating.getRating());
		
	}

}
