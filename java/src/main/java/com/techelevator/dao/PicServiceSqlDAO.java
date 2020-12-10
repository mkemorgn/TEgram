package com.techelevator.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PicServiceSqlDAO implements PicServiceDAO{
	
    private JdbcTemplate jdbcTemplate;

    public PicServiceSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public void likePicture(int pictureId, int userId) {
		String sql = "INSERT INTO likes (picture_id, user_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, pictureId, userId);
		
	}

}
