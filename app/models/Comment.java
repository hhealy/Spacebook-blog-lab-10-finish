package models;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class Comment extends Model
{
	public String comment;
	public String date;
	public long postId;

	@ManyToOne
	public User commentAuthor;

	public Comment(User commentAuthor, String comment, Long postId, String date)
	{
	    this.comment = comment;
	    this.commentAuthor = commentAuthor;
	    this.postId = postId;
	    this.date = date;
	}

	public String toString()
	{
		return comment;
	} 
}