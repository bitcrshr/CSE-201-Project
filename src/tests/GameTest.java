package tests;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

import data_classes.Game;
import data_classes.Profile;

import java.util.ArrayList;

//Changhao Li (lic74@miamioh.edu)
class GameTest {

	@Test
	void Functiontest() {
		Profile myprofile = new Profile("tester","mypassword");
		ArrayList<String> mycomments = new ArrayList<String>();
		ArrayList<String> mypreviews = new ArrayList<String>();
		Game mygame = new Game(myprofile, 20.1, mycomments,"description", mypreviews);
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
		assertTrue(mygame.getPreviews() == mypreviews);
		ArrayList<String> previewscomments = new ArrayList<String>();
		mygame.setPreviews(previewscomments);
		assertTrue(mygame.getPreviews() == previewscomments);
		assertTrue(mygame.getUploader() == myprofile);
		
		
	}

}
