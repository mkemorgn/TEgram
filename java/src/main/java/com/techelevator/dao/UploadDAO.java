package com.techelevator.dao;

import org.springframework.web.multipart.MultipartFile;

public interface UploadDAO {
	
	Pictures upload(MultipartFile file);

}
