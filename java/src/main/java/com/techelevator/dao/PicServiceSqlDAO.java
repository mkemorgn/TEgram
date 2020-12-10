package com.techelevator.dao;

import javax.xml.stream.events.Comment;

import org.springframework.data.relational.core.sql.Like;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.Rating;

@Component
public class PicServiceSqlDAO implements PicServiceDAO{
	
	private JdbcTemplate jdbcTemplate;
	public PicServiceSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}
	

	@Override
	public Like addLike(int pictureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLike(int pictureId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment addComment(int pictureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeComment(int pictureId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rating addRating(int pictureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating changeRating(int pictureId) {
		// TODO Auto-generated method stub
		return null;
	}

}
