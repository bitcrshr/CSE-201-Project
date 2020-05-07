package models;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to represent a Game.
 * @author Chandler Davis (davisc10@miamioh.edu)
 *
 */
public class Game implements Serializable {
	/**
	 * Variable for the Game class
	 */
	private String name;
	private static final long serialVersionUID = 6746977338198319164L;
	private final Profile uploader;
	private double rating;
	private ArrayList<String> comments;
	private String description;
	private String previewLink;
	private genre g;
	private platform p;
	
	/*
	 * Constructors for the Game Class
	 */
	
	// Workhorse constructor
	public Game(String name, Profile uploader, double rating, ArrayList<String> comments, String description, String previewLink, genre g, platform p) {
		this.name = name;
		this.uploader = uploader;
		this.rating = rating;
		this.comments = comments;
		this.description = description;
		//this.previews = new ArrayList<String>(previews);
		this.previewLink = (previewLink == null) ? "https://picsum.photos/seed/" + name + "/300/300" : previewLink;
		this.g = g;
		this.p = p;
	}
	
	//Empty constructor
	public Game() {
		this("",null,0.0,new ArrayList<String>(),"","",null,null);
	}
	
	public Game(String name,Profile uploader, String description, String previewLink, genre g,platform p) {
		this(name,uploader, 0.0, null, description, previewLink,g,p);
	}
	
	public Game(String name,Profile uploader, String description, String previewLink) {
		this(name,uploader, 0.0, null, description, previewLink,null,null);
	}
	
	public Game(String name,String description,genre g,platform p) {
		this(name,null,0.0,null,description,null,g,p);
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

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	public Profile getUploader() {
		return uploader;
	}
	
	public platform getPlatform() {
		return p;
	}
	
	public void setPlatform(platform p) {
		this.p = p;
	}
	
	public genre getGenre() {
		return g;
	}
	
	public void setGenre(genre g) {
		this.g = g;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((g == null) ? 0 : g.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((previewLink == null) ? 0 : previewLink.hashCode());
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
		if (g == null) {
			if (other.g != null)
				return false;
		} else if (!g.equals(other.g))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (previewLink == null) {
			if (other.previewLink != null)
				return false;
		} else if (!previewLink.equals(other.previewLink))
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
