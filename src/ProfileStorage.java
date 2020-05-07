import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A singleton class to store and retrieve Profiles from a backend.
 * @author Chandler Davis (davisc10)
 *
 */
public class ProfileStorage {
	private static ProfileStorage instance;
	
	private HashMap<String, Profile> profileMap;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private File file;
	
	private final String STORAGE_FILENAME = "profiles.data";
	
	/**
	 * Private constructor to prevent outside instantiation.
	 */
	private ProfileStorage() {}
	
	/**
	 * Returns the static instance of this class.
	 * @return the static instance of this class.
	 */
	public static ProfileStorage getInstance() {
		if (instance == null)
			instance = new ProfileStorage();
		
		return instance;
	}
	
	/**
	 * Clears the backend of all profiles. This cannot be undone.
	 */
	public void clear() {
		profileMap = null;
		
		(new File(STORAGE_FILENAME)).delete();
	}
	
	/**
	 * Stores a Profile in the backend.
	 * @param profile the profile to store
	 * @return true if successful, false otherwise.
	 */
	public boolean storeProfile(Profile profile) {		
		checkMapInstantiation();
		
		if (profileMap.containsValue(profile))
			return false;
		
		profileMap.put(profile.getUserName(), profile);
		
		try {
			writeToFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Gets a Profile from the backend.
	 * @param username the username of the profile to retrieve
	 * @return the Profile matching the username, if it exists.
	 */
	public Profile getProfile(String username) {
		checkMapInstantiation();
		
		return profileMap.get(username);
	}
	
	/**
	 * Checks to see if a profile already exists.
	 * @param username the username of the profile.
	 * @return true if the profile exists, false otherwise.
	 */
	public boolean profileExists(String username) {
		checkMapInstantiation();
		
		return profileMap.containsKey(username);
	}
	
	/**
	 * Deletes a profile from the backend.
	 * @param username the username of the profile to delete
	 * @return true if successful, false otherwise.
	 */
	public boolean deleteProfile(String username) {
		checkMapInstantiation();
		
		boolean successful = profileMap.remove(username) != null;
		(new File(STORAGE_FILENAME)).delete();
		
		try {
			writeToFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return successful;
	}
	
	/**
	 * Loads in test profile data from CSV. 
	 * @param filename the name of the CSV file to load in
	 * @param destructive whether the old file should be replaced or not
	 * @return true if the operation is successful, false otherwise.
	 */
	public boolean loadFromCSV(String filename, boolean destructive) {
		checkMapInstantiation();
		if (destructive)
			clear();
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			
			scanner.nextLine();
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] props = line.split(",");
				
				storeProfile(new Profile(props[0], props[1], false, new ArrayList<Game>(), props[2], "https://picsum.photos/500/500"));
			}
			scanner.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void checkMapInstantiation() {
		if (profileMap == null) {
			try {
				profileMap = loadFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Profile> loadFromFile() throws IOException, ClassNotFoundException {
		file = new File(STORAGE_FILENAME);
		
		if (!file.exists())
			return new HashMap<String, Profile>();
		
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		
		HashMap<String, Profile> map = (HashMap<String, Profile>) objectInputStream.readObject();
		
		objectInputStream.close();
		fileInputStream.close();
					
		return map;
				
	}
	
	private void writeToFile() throws IOException {
		file = new File(STORAGE_FILENAME);
		file.delete();
		
		fileOutputStream = new FileOutputStream(file);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(profileMap);
		
		objectOutputStream.close();
		fileOutputStream.close();
	}
}
