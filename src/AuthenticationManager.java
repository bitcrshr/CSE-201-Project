/**
 * A singleton class to handle all authentication.
 * @author Chandler Davis (davisc10)
 *
 */
public class AuthenticationManager {
	private static AuthenticationManager instance;
	
	private Profile currentUser;
	
	/**
	 * Private constructor to prevent outside instantiation
	 */
	private AuthenticationManager() {}
	
	/**
	 * Provides a static instance of AuthenticationManager
	 * @return a static instance of AuthenticationManager
	 */
	public static AuthenticationManager getInstance() {
		if (instance == null)
			instance = new AuthenticationManager();
		
		return instance;
	}
	
	/**
	 * Returns the current user who is logged in, if any.
	 * @return the current user if one exists, null otherwise.
	 */
	public Profile currentUser() {
		return (currentUser == null) ? null : new Profile(currentUser);
	}
	
	/**
	 * Attempts a sign in with the given username and password
	 * @param username the username
	 * @param password the password
	 * @return a Profile matching the username if the password is correct, and null otherwise
	 */
	public Profile signIn(String username, String password) {
		Profile profile = ProfileStorage.getInstance().getProfile(username);
		
		if (profile == null)
			return null;
		
		if (!profile.getPassword().equals(password))
			return null;
		
		currentUser = profile;
		
		return new Profile(profile);
	}
	
	/**
	 * Attempts to sign up a user with the given username and password. If sign up is successful, the user will also be signed in.
	 * @param username the username
	 * @param password the password
	 * @return true if the sign up is sucessful, false otherwise (e.g., the user already exists)
	 */
	public boolean signUp(String username, String password) {
		if (ProfileStorage.getInstance().profileExists(username)) {
			return false;
		}
				
		return ProfileStorage.getInstance().storeProfile(new Profile(username, password)) && (this.signIn(username, password) != null);
	}
	
	/**
	 * Signs out the current user, if one exists.
	 * @return true if the sign out is successful, false otherwise.
	 */
	public boolean signOut() {
		if (currentUser == null) {
			return false;
		}
		
		currentUser = null;
		return true;
	}
}
