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
	 * Updates a profile if and only if the username of the profile to update is logged in.
	 * @param updatedProfile the updated profile (the username must match the currentUser)
	 * @return true if successful, false otherwise.
	 */
	public boolean updateProfile(Profile updatedProfile) {
		if (currentUser != null && updatedProfile.userName.equals(currentUser.userName)) {
			return ProfileStorage.getInstance().storeProfile(updatedProfile);
		}
		
		return false;
	}
	
	/**
	 * Attempts a sign in with the given username and password
	 * @param username the username
	 * @param password the password
	 * @return a Profile matching the username if the password is correct, and null otherwise
	 */
	public boolean signIn(String username, String password) {
		Profile profile = ProfileStorage.getInstance().getProfile(username);
		
		if (profile == null)
			//return null;
			return false;
		
		if (!profile.getPassword().equals(password))
			//return null;
			return false;
		
		currentUser = profile;
		
		//return new Profile(profile);
		return true;
	}
	
	/**
	 * Attempts to sign up a user with the given username and password. If sign up is successful, the user will also be signed in.
	 * @param username the username
	 * @param password the password
	 * @return true if the sign up is successful, false otherwise (e.g., the user already exists)
	 */
	public boolean signUp(String username, String password) {
		if (ProfileStorage.getInstance().profileExists(username)) {
			return false;
		}
				
		return ProfileStorage.getInstance().storeProfile(new Profile(username, password)) && (this.signIn(username, password));
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
