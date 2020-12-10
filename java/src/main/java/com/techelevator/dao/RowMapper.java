package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Picture;

public class RowMapper {
	
	
	public static Picture mapRowsetToPicture(SqlRowSet rowSet) {
		Picture newPic = null;
		if (rowSet.next())
			newPic = new Picture(rowSet.getInt("picture_id"), rowSet.getInt("user_id"), rowSet.getString("pic_url"),
					rowSet.getString("pic_server_name"), rowSet.getString("pic_name"), rowSet.getString("description"),
					rowSet.getBoolean("private"));

		return newPic;

	}
	
	public static List<Picture> mapRowsetToPictureList(SqlRowSet rowSet) {
		List<Picture> picList =new ArrayList<Picture>();
		while(rowSet.next()) {
		Picture  newPic = new Picture(rowSet.getInt("picture_id"), rowSet.getInt("user_id"), rowSet.getString("pic_url"),
					rowSet.getString("pic_server_name"), rowSet.getString("pic_name"), rowSet.getString("description"),
					rowSet.getBoolean("private"));
		picList.add(newPic);
		}

		return picList;

	}

}
