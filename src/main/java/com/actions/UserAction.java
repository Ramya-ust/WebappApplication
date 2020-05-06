package com.actions;

import org.apache.log4j.Logger;

import com.seller.User;

public class UserAction {

	static Logger log = Logger.getLogger(UserAction.class);
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String execute()
	{
		if(("admin".equalsIgnoreCase(user.getName()))&&("admin".equalsIgnoreCase(user.getPassword())))
		{
			log.info("Logged in to seller account");
		return "success";
		}
		else
		{
			log.info("Login failed in to seller account");
			return "failure";
		}
		
	}
	
}
