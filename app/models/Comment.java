package models;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class Comment extends Model
{
	@Lob
	public String comment;
	@ManyToOne
	public User commentAuthor;
	@ManyToOne
	public Post postAuthor;

	public Comment(User commentAuthor, Post postAuthor, String comment)
	{
	    this.comment = comment;
	    this.commentAuthor = commentAuthor;
	    this.postAuthor = postAuthor;
	}

	public String toString()
	{
		return comment;
	} 
}