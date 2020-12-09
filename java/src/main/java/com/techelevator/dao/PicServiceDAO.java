package com.techelevator.dao;

import javax.xml.stream.events.Comment;

import org.springframework.data.relational.core.sql.Like;

import com.techelevator.model.Rating;

public interface PicServiceDAO {
	
	Like addLike (int pictureId);
	void removeLike (int pictureId);
	Comment addComment (int pictureId);
	void removeComment (int pictureId);
	Rating addRating (int pictureId);
	Rating changeRating (int pictureId);

}
