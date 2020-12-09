package com.techelevator.dao;

import org.springframework.web.multipart.MultipartFile;

import com.techelevator.model.Picture;

public interface UploadDAO {
	
	Picture upload(MultipartFile file, int userID, String picName, String desc, boolean isPrivate);

}
