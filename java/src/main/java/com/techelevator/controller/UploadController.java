package com.techelevator.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techelevator.dao.UploadDAO;
import com.techelevator.model.Picture;

@RestController
@CrossOrigin(origins = { "http://localhost:8081", "http://127.0.0.1:8081" })
public class UploadController {

	private UploadDAO uploadDAO;

	public UploadController(UploadDAO uploadDAO) {

		this.uploadDAO = uploadDAO;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public Picture upload(@RequestParam("file") MultipartFile file, 
			@RequestParam(value = "userID") int userID,
			@RequestParam(value = "desc", defaultValue = "") String desc,
			@RequestParam(value = "isPrivate", required = false) boolean isPrivate) {
	
		return uploadDAO.upload(file, userID, desc, isPrivate);
	}

}
