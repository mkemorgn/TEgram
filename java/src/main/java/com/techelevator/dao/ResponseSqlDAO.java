package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.ResponseDAO;
import com.techelevator.model.Picture;
import com.techelevator.dao.RowMapper;



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

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId);
       pictures= RowMapper.mapRowsetToPictureList(rowSet);

        return pictures;
    }
	@Override
	public List<Picture> userFav(int userId, int favoriteID) {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT * from pictures p JOIN favorite_picture fp ON p.picture_id = fp.picture_id " +
		             "JOIN favorites f ON fp.favorite_id = f.favorite_id WHERE p.user_id = ? AND f.favorite_id =?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId, favoriteID);
       pictures= RowMapper.mapRowsetToPictureList(rowSet);
        
        return pictures;
	}

	@Override
	public List<Picture> home() {
		List<Picture> pictures = new ArrayList<>();
        String sql = "SELECT * from pictures WHERE private = 'false'";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        pictures=RowMapper.mapRowsetToPictureList(rowSet);
        
        return pictures;
	}

	
}
