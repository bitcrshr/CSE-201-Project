package tests;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

import models.Game;
import models.Profile;
import models.genre;
import models.platform;

import java.util.ArrayList;

//Changhao Li (lic74@miamioh.edu)
class GameTest {

	@Test
	void Functiontest() {
		String gameName = "League of Legends";
		Profile myprofile = new Profile("tester","mypassword");
		ArrayList<String> mycomments = new ArrayList<String>();
		String mypreview = "";
		Game mygame = new Game(gameName,myprofile, 20.1, mycomments,"description", mypreview, genre.ALL, platform.WINDOWS);
		assertTrue(mygame.comment(myprofile, "newComment"));
		assertTrue(mygame.delete(myprofile, "newComment"));
		assertTrue(mygame.editOwnComment(myprofile, "oldComment","newComment"));
		assertTrue(mygame.editDesc(myprofile, "newDesc"));
		assertTrue(mygame.editPreviews(myprofile, mycomments));
		assertTrue(mygame.getRating() == 20.1);
		mygame.setRating(20.2);
		assertTrue(mygame.getRating() == 20.2);
		ArrayList<String> newcomments = new ArrayList<String>();
		mygame.setComments(newcomments);
		assertTrue(mygame.getComments() == newcomments);
		
		assertTrue(mygame.getDescription() == "description");
		assertTrue(mygame.getPreviewLink() == mypreview);
		ArrayList<String> previewscomments = new ArrayList<String>();
//		mygame.setPreviewLink(previewscomments);
//		assertTrue(mygame.getPreviewLink() == previewscomments);
		assertTrue(mygame.getUploader() == myprofile);
		
		
	}

}
