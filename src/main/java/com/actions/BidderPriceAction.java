package com.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.dao.DBmanager;
import com.seller.Bidderprice;

public class BidderPriceAction {
	  static Logger log = Logger.getLogger(BidderPriceAction.class);

	private Bidderprice bid;

	public Bidderprice getBid() {
		return bid;
	}

	public void setBid(Bidderprice bid) {
		this.bid = bid;
	}
	
	
	public String execute()
	{
		DBmanager db = new DBmanager();
		Connection con = db.getConnection();
		if(con==null)
		{ log.info("connection failed");
			//System.out.print("connection failed");
		}
		else
		{ log.info("connection succeded");
			//System.out.print("connection succeded");
		}

		
		try {
			
			/*Statement stmt = con.createStatement();*/
			String sql="insert into bidderprice"+"(bidderprice)"+"values(?)";
		
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		     preparedStmt.setInt (1, bid.getBidderprice());
//	preparedStmt.executeUpdate();
		      // execute the preparedstatement  	ResultSet rs=
		    preparedStmt.executeUpdate();
		        
		      String query1=" UPDATE bidder t1 INNER JOIN additem t2 SET t1.item = t2.itemname";
		      Statement stmt1 = con.createStatement();
		      stmt1.executeUpdate(query1);	   
		      
		      log.info("updated item name in bidder table");
		      
		      String query2=" UPDATE bidder t1 INNER JOIN bidderprice t2 ON t1.id=t2.id SET t1.price = t2.bidderprice; ";
		      Statement stmt2 = con.createStatement();
		      stmt2.executeUpdate(query2);
		      log.info("updated the price of bidder in bidder table");
		      con.close();
		     
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			 log.info(e1.getMessage());
		      //System.err.println(e1.getMessage());
		}
		//System.out.print("insert complete for bidder price and inserted in bidder table");
	
		return "success";
	}
	}


