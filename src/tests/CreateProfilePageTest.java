package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import pages.CreateProfilePage;

public class CreateProfilePageTest {

	@Test
	public void createProfilePageTest() {
		CreateProfilePage page = new CreateProfilePage();
		page.setVisible(true);
		
		while(page.getProfile() == null) {}
		
		assertTrue(page.getProfile().getUserName().equals("hello"));
		
	}

}
