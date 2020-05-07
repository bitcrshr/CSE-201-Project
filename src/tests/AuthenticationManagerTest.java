package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.AuthenticationManager;

class AuthenticationManagerTest {

	@Test
	void testGetInstance() {
		assertTrue(AuthenticationManager.getInstance() != null);
		assertTrue(AuthenticationManager.getInstance() instanceof AuthenticationManager);
	}

	@Test
	void testSignIn() {
		AuthenticationManager.getInstance().signUp("username", "password");
		
		assertTrue(AuthenticationManager.getInstance().signIn("username", "password"));
		assertFalse(AuthenticationManager.getInstance().signIn("username", "wrongpassword"));
		assertFalse(AuthenticationManager.getInstance().signIn("DNE", "fake"));
		
		AuthenticationManager.getInstance().signOut();
	}

	@Test
	void testSignUp() {
		String randomString = String.valueOf(Math.random());
		
		assertTrue(AuthenticationManager.getInstance().signUp(randomString, "newpassword"));
		assertFalse(AuthenticationManager.getInstance().signIn(randomString, "newpassword"));
	}

	@Test
	void testSignOut() {
		assertFalse(AuthenticationManager.getInstance().signOut());
		AuthenticationManager.getInstance().signUp("username", "password");
		AuthenticationManager.getInstance().signIn("username", "password");
		
		assertTrue(AuthenticationManager.getInstance().signOut());
	}
	
	@Test
	void testCurrentUser() {
		AuthenticationManager.getInstance().signOut();
		
		assertTrue(AuthenticationManager.getInstance().currentUser() == null);
		
		AuthenticationManager.getInstance().signUp("username", "password");
		AuthenticationManager.getInstance().signIn("username", "password");
		
		assertTrue(AuthenticationManager.getInstance().currentUser().getUserName().equals("username"));
		
		AuthenticationManager.getInstance().signOut();
	}

}
