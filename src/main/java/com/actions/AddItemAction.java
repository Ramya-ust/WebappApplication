package com.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.dao.DBmanager;
import com.seller.Item;

public class AddItemAction {
	  static Logger log = Logger.getLogger(AddItemAction.class);
	
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
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
			log.info("connection succeeded");
			//System.out.print("connection succeded");
		}
		try{
		String sql1="create table bidder(id int  AUTO_INCREMENT  PRIMARY KEY,name varchar(20) not null,email varchar(20) not null,phone varchar(20),"+
"address varchar(20),item varchar(20),price int)";
		
		String sql2="create table additem(itemname varchar(10) not null,itemprice int)";
		String sql3="create table bidderprice(id int  AUTO_INCREMENT primary key,bidderprice int)";
		
		Statement stmt = con.createStatement();
		stmt.execute(sql1);
		Statement stmt1 = con.createStatement();
		stmt1.execute(sql2);
		Statement stmt2 = con.createStatement();
		stmt2.execute(sql3);
		}
		catch(Exception e)
		{
			log.info("exceeption while creating sql table");
			//System.out.println("exceeption while creating sql table");
		}
		try {
			/*Statement stmt;
			stmt = con.createStatement();*/
			String sql="insert into additem"+"(itemname,itemprice)"+"values(?,?)";
		//	stmt.executeUpdate(sql);
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		      preparedStmt.setString (1, item.getItemname());
		      preparedStmt.setInt(2, item.getItemprice());
		      // execute the preparedstatement
		      preparedStmt.execute();

		    
		      con.close();
		      log.info("insert complete of item and also added in table bidder");
		      
		   //   System.out.print("insert complete of item and also added in table bidder");
		      return "success";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			log.info("Got an exception!", e1);
			// System.err.println("Got an exception!");
		    log.info(e1.getMessage()); 
		    //System.err.println(e1.getMessage());
		  	return null;
		}
		
	
	
		
	}
	
	
}
