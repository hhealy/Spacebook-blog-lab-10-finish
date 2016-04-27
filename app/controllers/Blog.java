package controllers;

import java.util.List;

import models.Comment;
import models.Message;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

public class Blog  extends Controller
{
  public static void index()
  {
    User user = Accounts.getLoggedInUser();
    render(user);
  }
  
  public static void newPost(String title, String content)
  {
    User user = Accounts.getLoggedInUser();
    
    Post post = new Post (title, content);
    post.save();
    user.posts.add(post);
    user.save();
    
    Logger.info ("title:" + title + " content:" + content);
    index();
  }
  
  public static void newComment(Long userId, Long postId, String comment)
  {
	  User user = Accounts.getLoggedInUser();
	  Post post = Post.findById(postId);
	  
	  Comment commentTwo = new Comment(user, post, comment);
	  user.comments.add(commentTwo);
	  post.comments.add(commentTwo);
	  commentTwo.save();
	  Logger.info ("comment:" + comment);
	  index();
  }
}