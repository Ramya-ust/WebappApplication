package com.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.dao.DBmanager;
import com.opensymphony.xwork2.ActionSupport;
import com.seller.Bidder;

public class BidderAction extends ActionSupport{
	static Logger log = Logger.getLogger(BidderAction.class);
	
	private Bidder userBean;

	public Bidder getUserBean() {
		return userBean;
	}

	public void setUserBean(Bidder userBean) {
		this.userBean = userBean;
	}

	
	public void validate()
	{
		if("".equals(userBean.getName())){
			addFieldError("username", getText("username.required"));
			log.info("Username is required");
		}
		if("".equals(userBean.getEmail())){
			addFieldError("password", getText("password.required"));
			log.info("email is required");
		}
		
		
	}

	/*public String execute()
	{
		return "success";
	}*/

	public String execute()
	{
	

		DBmanager db = new DBmanager();
		Connection con = db.getConnection();
		if(con==null)
		{
			log.info("connection failed");
			//System.out.print("connection failed");
		}
		else
		{
			log.info("connection succeded");
			//System.out.print("connection succeded");
		}

		
		try {
			/*Statement stmt;
			stmt = con.createStatement();*/
			String sql="insert into bidder"+"(name,email,phone,address)"+"values(?,?,?,?)";
		//	stmt.executeUpdate(sql);
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		      preparedStmt.setString (1, userBean.getName());
		      preparedStmt.setString (2, userBean.getEmail());
		      preparedStmt.setString(3, userBean.getPhone());
		      preparedStmt.setString(4, userBean.getAddress());
		      // execute the preparedstatement
		      preparedStmt.execute();
		      log.info("inserted bidder contact information to database");
		     con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		log.info("Got an exception!", e1);
		      System.err.println(e1.getMessage());
		}
		//System.out.print("insert complete");
	
		return "success";
	}
	
}
