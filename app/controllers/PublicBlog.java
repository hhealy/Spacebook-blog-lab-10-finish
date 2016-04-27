package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class PublicBlog extends Controller
{
  public static void visit(Long id)
  {
    User user = User.findById(id);
    Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
    render(user);
  }

  public static void sendComment(Long id, String comment, Long postId)
  {
    User from = Accounts.getLoggedInUser();
    Date date = new Date();
    String time = date.toString();
     if(from != null)
     {
    	 User to = User.findById(id);
    	 Logger.info("comment from user " + 
    		        from.firstName + ' ' + from.lastName +" to " +
    		        to.firstName + ": " +
    		        comment);   
         from.sendComment(to, comment, postId, time);
         visit(id);
     }
     else
     {
    	 visit(id);
     }
  }  
}