package com.techelevator.dao;

<<<<<<< HEAD
public interface PicServiceDAO {
	
	public void likePicture(int pictureId, int userId);
	
=======
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

>>>>>>> 1ed9d7c9b4796cadd3bb0d13d0ee0ebd4013b3e1
}
