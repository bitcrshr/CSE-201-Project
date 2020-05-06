import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GameStorageTest {
	private Game testGame1 = new Game(
		"name",
		new Profile("user", "password"),
		3.2,
		new ArrayList<String>(),
		"testDescription",
		new ArrayList<String>(),
		genre.ALL,
		platform.ALL
	);
	
	private Game testGame2 = new Game(
			"name2",
			new Profile("user2", "password2"),
			2.8,
			new ArrayList<String>(),
			"testDescription2",
			new ArrayList<String>(),
			genre.ALL,
			platform.ALL
	);

	@Test
	void testGetInstance() {
		assertTrue(GameStorage.getInstance() != null);
		assertTrue(GameStorage.getInstance() instanceof GameStorage);
	}

	@Test
	void testClear() {
		GameStorage.getInstance().storeGame(testGame1);
		GameStorage.getInstance().clear();
		
		assertFalse(GameStorage.getInstance().gameExists(testGame1.getName()));
	}

	@Test
	void testStoreGame() {
		ProfileStorage.getInstance().clear();
		
		assertTrue(GameStorage.getInstance().storeGame(testGame1));
	}

	@Test
	void testGetGame() {
		GameStorage.getInstance().clear();
		
		GameStorage.getInstance().storeGame(testGame1);
		Game g = GameStorage.getInstance().getGame(testGame1.getName());
		
		assertTrue(g.getName().equals(testGame1.getName()));
	}

	@Test
	void testGameExists() {
		GameStorage.getInstance().clear();

		GameStorage.getInstance().storeGame(testGame1);
		
		assertTrue(GameStorage.getInstance().gameExists(testGame1.getName()));
		assertFalse(GameStorage.getInstance().gameExists(testGame2.getName()));
	}

	@Test
	void testDeleteGame() {
		GameStorage.getInstance().clear();
		
		GameStorage.getInstance().storeGame(testGame1);
		
		assertFalse(GameStorage.getInstance().deleteGame(testGame2.getName()));
		assertTrue(GameStorage.getInstance().deleteGame(testGame1.getName()));
		assertFalse(GameStorage.getInstance().deleteGame(testGame1.getName()));
	}
	
	@Test
	void testToArray() {
		GameStorage.getInstance().clear();
		
		assertTrue(GameStorage.getInstance().toArray().length == 0);
		
		GameStorage.getInstance().storeGame(testGame1);
		assertTrue(GameStorage.getInstance().toArray().length == 1);
		assertTrue(GameStorage.getInstance().toArray()[0].equals(testGame1));
		GameStorage.getInstance().storeGame(testGame2);
		assertTrue(GameStorage.getInstance().toArray().length == 2);
		assertTrue(GameStorage.getInstance().toArray()[1].equals(testGame2));
	}

}
