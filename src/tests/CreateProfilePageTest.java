package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import ui.CreateProfilePage;

public class CreateProfilePageTest {

	@Test
	public void createProfilePageTest() {
		CreateProfilePage page = new CreateProfilePage(false);
		page.setVisible(true);
		
		while(page.getProfile() == null) {}
		
		assertTrue(page.getProfile().getUserName().equals("hello"));
		
	}

}
