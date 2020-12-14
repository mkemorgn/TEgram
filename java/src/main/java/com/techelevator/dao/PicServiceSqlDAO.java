package com.techelevator.dao;



import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
	public void removeLike(int pictureId, int userId) {
		String sql ="DELETE FROM likes WHERE picture_id=? AND user_id=?";
		
		try {
			jdbcTemplate.update(sql, pictureId, userId);
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
	
	
	//helpers
	public List<Likes> getLikesByPicId(int pictureId){
		String sql ="SELECT like_id, picture_id, l.user_id, u.username FROM likes l "
				+ "JOIN users u ON u.user_id=l.user_id WHERE l.picture_id=?";
		SqlRowSet rowSet; 
		try {
			 rowSet= jdbcTemplate.queryForRowSet(sql, pictureId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return RowMapper.mapRowsetToLikeList(rowSet);
	}
	
	public List<Comments> getCommentsByPicId(int pictureId){
		String sql ="SELECT comment_id, picture_id, c.user_id, comment, u.username FROM comments c "
				+ "JOIN users u ON u.user_id=c.user_id WHERE c.picture_id=?";
		SqlRowSet rowSet; 
		try {
			 rowSet= jdbcTemplate.queryForRowSet(sql, pictureId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return RowMapper.mapRowsetToCommentList(rowSet);
	}
	
	public List<Ratings> getRatingsByPicId(int pictureId){
		String sql ="SELECT rating_id, picture_id, r.user_id, rating, u.username FROM ratings r "
				+ "JOIN users u ON u.user_id=r.user_id WHERE r.picture_id=?";
		SqlRowSet rowSet; 
		try {
			 rowSet= jdbcTemplate.queryForRowSet(sql, pictureId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		return RowMapper.mapRowsetToRatingList(rowSet);
	}

}
