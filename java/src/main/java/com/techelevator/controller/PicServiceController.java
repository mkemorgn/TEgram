package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PicServiceDAO;

@RestController
@CrossOrigin(origins = { "http://localhost:8081", "http://127.0.0.1:8081" })
public class PicServiceController {
	
	private PicServiceDAO picServiceDAO;
	
	public PicServiceController(PicServiceDAO picServiceDAO) {
		this.picServiceDAO = picServiceDAO;
	}
	
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public void likePicture() {
		picServiceDAO.likePicture(1, 1);						///hard coded 1, 1 for now; this needs to take the user_id and the picture_id 
		
	}
	


}
