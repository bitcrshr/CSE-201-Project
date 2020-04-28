import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * A singleton class to store and retrieve Games from a backend.
 * @author Chandler Davis (davisc10)
 *
 */
public class GameStorage {
	private static GameStorage instance;
	
	private HashMap<String, Game> gameMap;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private File file;
	
	private final String STORAGE_FILENAME = "games.data";
	
	/**
	 * Private constructor to prevent outside instantiation.
	 */
	private GameStorage() {}
	
	/**
	 * Returns the static instance of this class.
	 * @return the static instance of this class.
	 */
	public static GameStorage getInstance() {
		if (instance == null)
			instance = new GameStorage();
		
		return instance;
	}
	
	/**
	 * Clears the backend of all Games. This cannot be done.
	 */
	public void clear() {
		gameMap = null;
		
		(new File(STORAGE_FILENAME)).delete();
	}
	
	/**
	 * Stores a Game in the backend
	 * @param game the game to store
	 * @return true if successful, false otherwise.
	 */
	public boolean storeGame(Game game) {
		checkMapInstantiation();
		
		if (gameMap.containsValue(game))
			return false;
		
		gameMap.put(game.getName(), game);
		
		try {
			writeToFile();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Gets a Game from the backend.
	 * @param name the name of the Game to retrieve
	 * @return the Game matching the name, if it exists.
	 */
	public Game getGame(String name) {
		checkMapInstantiation();
		
		return gameMap.get(name);
	}
	
	/**
	 * Checks to see if a Game already exists.
	 * @param name the name of the Game.
	 * @return true if the Game exists, false otherwise.
	 */
	public boolean gameExists(String name) {
		checkMapInstantiation();
		
		return gameMap.containsKey(name);
	}
	
	/**
	 * Deletes a Game from the backend
	 * @param name the name of the Game to delete
	 * @return true if successful, false otherwise.
	 */
	public boolean deleteGame(String name) {
		checkMapInstantiation();
		
		boolean successful = gameMap.remove(name) != null;
		(new File(STORAGE_FILENAME)).delete();
		
		try {
			writeToFile();
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return successful;
	}
	
	private void checkMapInstantiation() {
		if (gameMap == null) {
			try {
				gameMap = loadFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Game> loadFromFile() throws IOException, ClassNotFoundException {
		file = new File(STORAGE_FILENAME);
		
		if (!file.exists())
			return new HashMap<String, Game>();
		
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		
		HashMap<String, Game> map = (HashMap<String, Game>) objectInputStream.readObject();
		
		objectInputStream.close();
		fileInputStream.close();
		
		return map;
		
	}
	
	private void writeToFile() throws IOException {
		file = new File(STORAGE_FILENAME);
		file.delete();
		
		fileOutputStream = new FileOutputStream(file);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(gameMap);
		
		objectOutputStream.close();
		fileOutputStream.close();
	}
	
}