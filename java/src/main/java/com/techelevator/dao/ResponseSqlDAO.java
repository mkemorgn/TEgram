package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.ResponseDAO;
import com.techelevator.model.Favorites;
import com.techelevator.model.Picture;
import com.techelevator.dao.RowMapper;



@Component
public class ResponseSqlDAO implements ResponseDAO {
	
	private JdbcTemplate jdbcTemplate;
	private PicServiceSqlDAO picServiceSqlDAO; 

    public ResponseSqlDAO(JdbcTemplate jdbcTemplate, PicServiceSqlDAO picServiceSqlDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.picServiceSqlDAO =picServiceSqlDAO;
    }

	@Override
	public List<Picture> userPic(int userId) {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT picture_id, p.user_id, u.username, pic_url, pic_name, pic_server_name, description, private FROM pictures p "
        		+ "JOIN users u ON u.user_id=p.user_id WHERE p.user_id = ?";
        SqlRowSet rowSet;
		try {
			rowSet = jdbcTemplate.queryForRowSet(sql,userId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
       pictures= RowMapper.mapRowsetToPictureList(rowSet);

        return polulatePicList(pictures);
    }
	@Override
	public List<Picture> userFav(int userId, int favoriteID) {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT picture_id, p.user_id, u.username, pic_url, pic_name, pic_server_name, description, private FROM pictures p "
        		+ "JOIN favorite_picture fp ON p.picture_id = fp.picture_id " +
		             "JOIN favorites f ON fp.favorite_id = f.favorite_id "
		             + "JOIN users u ON u.user_id=p.user_id WHERE p.user_id = ? AND f.favorite_id =?";
        SqlRowSet rowSet;
		try {
			 rowSet = jdbcTemplate.queryForRowSet(sql,userId, favoriteID);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
       pictures= RowMapper.mapRowsetToPictureList(rowSet);
        
        return polulatePicList(pictures);
	}
	@Override
	public List<Picture> photoDetail(int pictureID) {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT picture_id, p.user_id, u.username, pic_url, pic_name, pic_server_name, description, private FROM pictures p "
		+ "JOIN users u ON u.user_id = p.user_id WHERE p.private = 'false' AND picture_id = ?";
        SqlRowSet rowSet ;
		try {
			rowSet = jdbcTemplate.queryForRowSet(sql, pictureID);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database: " + e.getMessage());
		}
        pictures=RowMapper.mapRowsetToPictureList(rowSet);
        
        return polulatePicList(pictures);
	}
	@Override
	public List<Picture> home() {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT picture_id, p.user_id, u.username, pic_url, pic_name, pic_server_name, description, private FROM pictures p "
        		+ "JOIN users u ON u.user_id=p.user_id WHERE p.private = 'false'";
        SqlRowSet rowSet ;
		try {
			rowSet = jdbcTemplate.queryForRowSet(sql);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
        pictures=RowMapper.mapRowsetToPictureList(rowSet);
        
        return polulatePicList(pictures);
	}
	
	@Override
	public List<Favorites> getFavoriteList(int userId) {
		List<Favorites> favorites= new ArrayList<>();
        String sql = "SELECT favorite_id, fav_name, f.user_id, u.username FROM favorites f "
        		+ "JOIN users u ON u.user_id=f.user_id WHERE u.user_id=?";
        SqlRowSet rowSet ;
		try {
			rowSet = jdbcTemplate.queryForRowSet(sql,userId);
		} catch (DataAccessException e) {
			throw new DataAccessResourceFailureException("Can not reach database " + e.getMessage());
		}
		favorites=RowMapper.mapRowsetToFavoriteList(rowSet);
		
		return favorites;
	}
	
	
	//helpers
	private List<Picture> polulatePicList(List<Picture> picList){
		
		for (Picture picture : picList) {
			if(picServiceSqlDAO.getRatingsByPicId(picture.getPictureId()).size()>0) {
				picture.setRatings(picServiceSqlDAO.getRatingsByPicId(picture.getPictureId()));
			}
			
			if(picServiceSqlDAO.getCommentsByPicId(picture.getPictureId()).size()>0) {
				picture.setComments(picServiceSqlDAO.getCommentsByPicId(picture.getPictureId()));
			}
			if(picServiceSqlDAO.getLikesByPicId(picture.getPictureId()).size()>0) {
				picture.setLikes(picServiceSqlDAO.getLikesByPicId(picture.getPictureId()));
			}
		}
		
		return picList;
	}

	
}
