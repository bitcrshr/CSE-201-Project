import static org.junit.Assert.*;

import org.junit.Test;

public class CreateProfilePageTest {

	@Test
	public void createProfilePageTest() {
		CreateProfilePage page = new CreateProfilePage(false);
		page.setVisible(true);
		
		while(page.getProfile() == null) {}
		
		assertTrue(page.getProfile().userName.equals("hello"));
		
	}

}
