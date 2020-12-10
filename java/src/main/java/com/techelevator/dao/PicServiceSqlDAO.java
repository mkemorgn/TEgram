package com.techelevator.dao;

<<<<<<< HEAD

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

=======
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

>>>>>>> 1ed9d7c9b4796cadd3bb0d13d0ee0ebd4013b3e1
}
