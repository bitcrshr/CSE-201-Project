import java.util.ArrayList;

//Changhao Li lic74
//04262020

// still need the database to finish the rest of functions
public class UpdateGame {
	
	String userName;
	String password;
	
	Game newGame = new Game();
	Profile userProfile = new Profile(userName, password);

	public UpdateGame() {
		
	}
	// constructor of the updateGame
	public UpdateGame(String userName,String password,Profile userProfile,Game newGame) {
		this.userName = userName;
		this.password = password;
		this.userProfile = userProfile;
		this.newGame = newGame;
	}
	
	// update the game to a temporary userProfile
	// check if the user exists, update the temporary user
	// switch the userProfile info with the database info if the update succeed.
	public void update(Profile userProfile,Game newGame) {
		if(validateUser(userProfile)) {
			ArrayList<Game> mygames = userProfile.getUpladedGames();
			mygames.add(newGame);
			userProfile.setUploadedGames(mygames);
			//set the temp user to the user in the database
		}
		else {System.out.println("user does not exist, please create a new user");}
	}
	public boolean validateUser(Profile userProfile) {
		boolean result = false;
		//check from the database if the user exists.
		return result;
	}
	
	
}
