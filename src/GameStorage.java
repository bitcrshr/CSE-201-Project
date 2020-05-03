import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

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
	private GameStorage() {
		loadFromCSV("gamedata.csv", true);
	}
	
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
	 * Loads in test game data from CSV. 
	 * @param filename the name of the CSV file to load in
	 * @param destructive whether the old file should be replaced or not
	 * @return true if the operation is successful, false otherwise.
	 */
	public boolean loadFromCSV(String filename, boolean destructive) {
		checkMapInstantiation();
		if (destructive)
			clear();
		
		Random random = new Random();
		genre[] gvals = genre.values();
		platform[] pvals = platform.values();
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			
			scanner.nextLine();
			String line;
			while (scanner.hasNextLine()) {
				genre randGenre = gvals[random.nextInt(gvals.length)];
				platform randPlatform = pvals[random.nextInt(pvals.length)];
				line = scanner.nextLine();
				String[] props = line.split(",");
				
				storeGame(new Game(props[0], null, ((double) random.nextInt(5) / random.nextInt(5)), null, props[1], null, randGenre, randPlatform));
			}
			scanner.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
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
	
	/**
	 * Returns an array of all game objects stored in the backend
	 * @return an array of all game objects stored in the backend
	 */
	public Game[] toArray() {
		checkMapInstantiation();
		
		if (gameMap == null)
			return new Game[0];
		
		Game[] games = new Game[gameMap.size()];
		gameMap.values().toArray(games);
		
		return games;
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