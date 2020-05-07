package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.ProfileStorage;
import models.Profile;

class ProfileStorageTest {

	@Test
	void testGetInstance() {
		assertTrue(ProfileStorage.getInstance() != null);
		assertTrue(ProfileStorage.getInstance() instanceof ProfileStorage);
	}

	@Test
	void testStoreProfile() {
		ProfileStorage.getInstance().clear();
		
		assertTrue(ProfileStorage.getInstance().storeProfile(new Profile("username", "password")));
	}

	@Test
	void testGetProfile() {
		ProfileStorage.getInstance().clear();
		
		ProfileStorage.getInstance().storeProfile(new Profile("username", "password"));
		Profile p = ProfileStorage.getInstance().getProfile("username");
		
		assertTrue(p.getUserName().equals("username") && p.getPassword().equals("password"));
	}

	@Test
	void testProfileExists() {
		ProfileStorage.getInstance().clear();

		ProfileStorage.getInstance().storeProfile(new Profile("username", "password"));
		
		assertTrue(ProfileStorage.getInstance().profileExists("username"));
		assertFalse(ProfileStorage.getInstance().profileExists("DNE"));
	}

	@Test
	void testDeleteProfile() {
		ProfileStorage.getInstance().clear();
		
		ProfileStorage.getInstance().storeProfile(new Profile("username", "password"));
		
		assertFalse(ProfileStorage.getInstance().deleteProfile("DNE"));
		assertTrue(ProfileStorage.getInstance().deleteProfile("username"));
		assertFalse(ProfileStorage.getInstance().profileExists("username"));
	}
	
	@Test
	void testClear() {
		ProfileStorage.getInstance().storeProfile(new Profile("username", "password"));
		ProfileStorage.getInstance().clear();
		
		assertFalse(ProfileStorage.getInstance().profileExists("username"));
	}

}
