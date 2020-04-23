//Dev: Changhao Li
//04232020

//description:
//this class contains the necessary download game function
//the game are stored in online drives like the google drive
//we store the links in a database if possible
//and return the link as string to the request
public class DownloadGame {
	
	String gameLink;
	String gameName;
	String[] gamelist = new String[999]; 
	static int downloadCount;
	
	//fetch the link from database
	public String getLinkfromDatabase() {
		//the code still needs to be implemented to fetch the link
		String link = "www.game.com";
		return link;
	}
	//change the link to a new link
	public void updateLink(String link) {
		this.gameLink = link;
	}
	
	//checks if the game exists in the database
	public boolean validGame(String inputgameName) {
		boolean result = false;
		String[] tempgamelist = this.gamelist; 
		for(int i = 0;i<tempgamelist.length;i++) {
			if(tempgamelist[i].equals(inputgameName)) {
				result = true;
			}
		}
		return result;
	}
	//get the game by game name if the game exists
	//increment the download time by one
	public String getLinkbyName(String inputgameName) {
		String link = "null";
		if(validGame(inputgameName)) {
			//implement the code to find game link from the database
			//link = gamelink;
			downloadCount++;
		}
		return inputgameName+link;
	}
	
}
