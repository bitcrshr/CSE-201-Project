import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to represent a Game.
 * @author Chandler Davis (davisc10@miamioh.edu)
 *
 */
public class Game implements Serializable {
	/**
	 * 
	 */
	private String name;
	private static final long serialVersionUID = 6746977338198319164L;
	private final Profile uploader;
	private double rating;
	private ArrayList<String> comments;
	private String description;
	private ArrayList<String> previews;
	private String platform;
	private String genre;
	
	public Game(String name, Profile uploader, double rating, ArrayList<String> comments, String description, ArrayList<String> previews,String platform,String genre) {
		this.name = name;
		this.uploader = uploader;
		this.rating = rating;
		//this.comments = new ArrayList<String>(comments);
		this.comments = comments;
		this.description = description;
		//this.previews = new ArrayList<String>(previews);
		this.previews = previews;
		this.platform = platform;
		this.genre = genre;
	}
	
	public Game() {
		this("",null,0.0,new ArrayList<String>(),"",new ArrayList<String>(),"","");
	}
	
	public Game(String name,Profile uploader, String description, ArrayList<String> previews,String platform,String genre) {
		this(name,uploader, 0.0, null, description, previews,platform,genre);
	}
	
	public Game(String name,String description,String platform,String genre){
		this(name,new Profile(),0.0,null,description,null,platform,genre);
	}
	
	public boolean comment(Profile commenter, String newComment) {
		return false;
	}
	
	public boolean delete(Profile commenter, String delComment) {
		return false;
	}
	
	public boolean editOwnComment(Profile commenter, String oldComment, String newComment) {
		return false;
	}
	
	public boolean editDesc(Profile user, String newDesc) {
		return false;
	}
	
	public boolean editPreviews(Profile user, ArrayList<String> newPreviews) {
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getPreviews() {
		return previews;
	}

	public void setPreviews(ArrayList<String> previews) {
		this.previews = previews;
	}

	public Profile getUploader() {
		return uploader;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform){
		this.platform = platform;
	}
	
	public String getGenre(){
		return genre;
	}
	
	public void setGenre(String genre){
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
		result = prime * result + ((previews == null) ? 0 : previews.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((uploader == null) ? 0 : uploader.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		if (previews == null) {
			if (other.previews != null)
				return false;
		} else if (!previews.equals(other.previews))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (uploader == null) {
			if (other.uploader != null)
				return false;
		} else if (!uploader.equals(other.uploader))
			return false;
		return true;
	}
	
	
}
