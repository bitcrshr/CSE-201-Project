import static org.junit.Assert.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;

/*
 * 
 * @author Charles O'Leary (olearyc3@miamioh.edu)
 * 
 */

public class ProfileTest {
	
	@Test
	public void testLogin() { //username password
		ProfileClass p = new ProfileClass("username", "password");
		assertTrue(p.getUserName().equals("username"));
		assertTrue(p.getUserName() == "username");
		assertTrue(p.getPassword().equals("password"));
		assertTrue(p.getPassword() == "password");
		assertFalse(p.login("wrongUsername", "wrongPassword"));
		assertTrue(p.login("username", "password"));
	}
	
	@Test
	public void testEditDescription() {
		ProfileClass p = new ProfileClass("username", "password", true, null, "this is my description", null);
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
		ProfileClass p = new ProfileClass("userName", "password", true, null, "description", null);
		assertTrue(p.getUserName().equals("username"));
		assertTrue(p.getPassword().equals("password"));
		assertTrue(p.getProfilePicture() == null);
		
		try {
			Image test = ImageIO.read(new File("TestImage.png"));
			assertTrue(p.editProfilePicture(test));
			assertFalse(p.getProfilePicture().equals(false));
			assertTrue(p.getProfilePicture() == test);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Testing for the uploadGame method not yet implemented
}
