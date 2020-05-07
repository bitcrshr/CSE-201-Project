import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class to represent a Profile.
 * @author Patrick Larmon (larmonpj@miamioh.edu)
 *
 */
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4873380397047408079L;
	String userName;
	String password;
	boolean admin;
	ArrayList<Game> uploadedGames;
	String description;
	String profilePictureLink;
	
	public Profile(String userName,
						String password,
						boolean admin
						,ArrayList<Game> uploadedGames,
						String description, 
						String profilePictureLink){
		
		setUserName(userName);
		setPassword(password);
		setAdmin(admin);
		setUploadedGames(uploadedGames);
		setDescription(description);
		setProfilePictureLink(profilePictureLink);
	}
	
	public Profile(String userName, String password){
		this(userName,password,false,null,"","https://picsum.photos/50/50");
	}
	
	public Profile(){
		this("","",false,null,"",null);
	}
	
	public Profile(Profile p) {
		this(p.userName, p.password, p.admin, p.uploadedGames, p.description, p.profilePictureLink);
	}
	
	public void setUserName(String user){
		userName = user;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
	
	public boolean getAdmin(){
		return admin;
	}
	
	public void setUploadedGames(ArrayList<Game> games){
		this.uploadedGames = games;
	}
	
	public ArrayList<Game> getUpladedGames(){
		return uploadedGames;
	}
	
	private void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return description;
	}
	
	private void setProfilePictureLink(String profilePicture){
		this.profilePictureLink = profilePicture;
	}
	
	public String getProfilePictureLink(){
		return profilePictureLink;
	}
	
	public boolean login(String userName,String password){
		return this.userName.equals(userName) && this.password.equals(password);
	}
	
	public boolean editDescription(String newDescription){
		setDescription(newDescription);
		return true;
	}
	
	public boolean editProfilePictureLink(String newLink){
		setProfilePictureLink(newLink);
		return true;
	}
	
	public boolean uploadGame(Game newGame){
		uploadedGames.add(newGame);
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((uploadedGames == null) ? 0 : uploadedGames.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Profile))
			return false;
		Profile other = (Profile) obj;
		if (admin != other.admin)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uploadedGames == null) {
			if (other.uploadedGames != null)
				return false;
		} else if (!uploadedGames.equals(other.uploadedGames))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
}
