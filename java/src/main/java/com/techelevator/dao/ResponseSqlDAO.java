package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.ResponseDAO;
import com.techelevator.model.Picture;



@Component
public class ResponseSqlDAO implements ResponseDAO {
	
	private JdbcTemplate jdbcTemplate;

    public ResponseSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<Picture> userPic(int userId) {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT * from pictures WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Picture picture = mapRowToPicture(results);
            pictures.add(picture);
        }

        return pictures;
    }
	@Override
	public List<Picture> userFav(int userId) {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT * from pictures p JOIN favorite_picture fp ON p.picture_id = fp.picture_id " +
		             "JOIN favorites f ON fp.favorite_id = f.favorite_id WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Picture picture = mapRowToPicture(results);
            pictures.add(picture);
        }
        
        return pictures;
	}

	@Override
	public List<Picture> home() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private Picture mapRowToPicture(SqlRowSet rs) {
        Picture picture = new Picture();
        picture.setPictureId(rs.getInt("picture_id"));
        picture.setUserId(rs.getInt("user_id"));
        picture.setPicUrl(rs.getString("pic_url"));
        picture.setPicServerName(rs.getString("pic_server_name"));
        picture.setPicName(rs.getString("pic_name"));
        picture.setDescription(rs.getString("description"));
        picture.setPrivate(false);
        return picture;
    }

	
}
