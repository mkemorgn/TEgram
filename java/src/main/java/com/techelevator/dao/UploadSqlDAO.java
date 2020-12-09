package com.techelevator.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.techelevator.model.Picture;

@Component
public class UploadSqlDAO implements UploadDAO {
	private JdbcTemplate jdbcTemplate;

	public UploadSqlDAO(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Picture upload(MultipartFile file, int userID, String picName, String desc, boolean isPrivate) {

		CloudinaryUpload uploadToCloudinary = new CloudinaryUpload();
		Map<String, String> cloudReturn = null;
		try {
			cloudReturn = uploadToCloudinary.toCloud(convert(file));
		} catch (IOException e) {

			e.printStackTrace();
		}

		String url = cloudReturn.get("secure_url").toString();
		String serverName = cloudReturn.get("public_id").toString();

		String sql = "INSERT INTO pictures (user_id, pic_url, pic_name, pic_server_name, description, private) "
				+ "VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, userID, url, picName, serverName, desc, isPrivate);

		return null;
	}

	// helpers
	private File convert(MultipartFile file) throws IOException {
		File temp = new File("src/main/resources/temp.jpg");
		FileOutputStream fos = new FileOutputStream(temp);
		fos.write(file.getBytes());
		fos.close();
		return temp;
	}
//	private Picture makePicture(int pictureId, int userId,  String picUrl, String picServerName, String picName, String description, boolean isPrivate) {
//		Picture newPic=new Picture();
//		
//	}

}
