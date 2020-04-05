import static org.junit.Assert.*;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;

public class ProfileTest {
	
	@Test
	public void testLogin() { //username password
		Profile p = new Profile("username", "password");
		assertTrue(p.getUserName().equals("username"));
		assertTrue(p.getPassword().equals("password"));
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
		assertFalse(p.getDescription().equasl("this is my description"));
		assertTrue(p.getDescription().equals("this is my new description"));
	}

	
	//for testing the image, i downloaded the screenshot of the getters/setters and
	//used that for the profile pic and renamed it to TestImage.png
	@Test
	public void testEditProfilePicture() {
		Profile p = new Profile("userName", "password", true, null, "description", null);
		assertTrue(p.getUserName().equals("username"));
		assertTrue(p.getPassword().equals("password"));
		assertTrue(p.getImage() == null);
		
		try {
			Image test = ImageIO.read(new File("TestImage.png"));
			assertTrue(p.editProfilePicture(test));
			assertFalse(p.getProfilePicture().equals(false));
			assertTrue(p.getProfilePicture() == test);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
// Method was left for iteration 3
//	@Test
//	public void testUploadGame() {
//		
//		
//	}
}
