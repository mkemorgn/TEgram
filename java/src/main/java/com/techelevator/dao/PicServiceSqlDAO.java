package com.techelevator.dao;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.Ratings;
import com.techelevator.model.Comments;
import com.techelevator.model.Likes;

@Component
public class PicServiceSqlDAO implements PicServiceDAO{
	
	private JdbcTemplate jdbcTemplate;
	public PicServiceSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}
	@Override
	public Likes addLike(int pictureId, int userId) {
		String sql ="INSERT INTO likes ( picture_id, user_id) VALUES ( ?, ?)";
		
		try {
			jdbcTemplate.update(sql, pictureId, userId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return null;
	}
	@Override
	public void removeLike(int likeId) {
		String sql ="DELETE FROM likes WHERE like_id=?";
		
		try {
			jdbcTemplate.update(sql, likeId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		
	}
	@Override
	public Comments addComment(int pictureId, int userId, String comment) {
		String sql ="INSERT INTO comments ( picture_id, user_id, comment) VALUES ( ?, ?, ?)";
		
		try {
			jdbcTemplate.update(sql, pictureId, userId, comment);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return null;
	}
	@Override
	public void removeComment(int commentId) {
		String sql ="DELETE FROM comments WHERE comment_id=?";
		
		try {
			jdbcTemplate.update(sql, commentId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		
	}
	@Override
	public Ratings addRating(int pictureId, int userId, int rating) {
		String sql ="INSERT INTO ratings ( picture_id, user_id, rating) VALUES ( ?, ?, ?)";
		
		try {
			jdbcTemplate.update(sql, pictureId, userId, rating);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return null;
	}
	@Override
	public Ratings changeRating(int ratingId, int rating) {
		String sql ="UPDATE ratings SET rating=? WHERE rating_id=?";
		
		try {
			jdbcTemplate.update(sql, rating, ratingId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return null;
	}

}
