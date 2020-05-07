package tests;
import static org.junit.Assert.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;

import models.Profile;

/*
 * 
 * @author Charles O'Leary (olearyc3@miamioh.edu)
 * 
 */

public class ProfileTest {
	
	@Test
	public void testLogin() { //username password
		Profile p = new Profile("username", "password");
		assertTrue(p.getUserName().equals("username"));
		assertTrue(p.getUserName() == "username");
		assertTrue(p.getPassword().equals("password"));
		assertTrue(p.getPassword() == "password");
		assertFalse(p.login("wrongUsername", "wrongPassword"));
		assertTrue(p.login("username", "password"));
	}
	
	@Test
	public void testEditDescription() {
		Profile p = new Profile("username", "password", true, null, "this is my description", null);
		assertTrue(p.getUserName().equals("username"));
		assertTrue(p.getPassword().equals("password"));
		assertTrue(p.getAdmin() == true);
		assertTrue(p.getDescription().equals("this is my description"));
		
		assertTrue(p.editDescription("this is my new description"));
		assertFalse(p.getDescription().equals("this is my description"));
		assertTrue(p.getDescription().equals("this is my new description"));
	}

	@Test
	public void testEditProfilePicture() {
		Profile p = new Profile("userName", "password", true, null, "description", null);
		assertTrue(p.getUserName().equals("userName"));
		assertTrue(p.getPassword().equals("password"));
		assertTrue(p.getProfilePictureLink() == null);
		
		String test = "https://picsum.photos/500/500";
		assertTrue(p.editProfilePictureLink(test));
		assertFalse(p.getProfilePictureLink().equals(false));
		assertTrue(p.getProfilePictureLink() == test);
	}
	
	//Testing for the uploadGame method not yet implemented
}
