<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dao.DBmanager" %>
    <%@page import="java.sql.Connection" %>
  <%@page import="java.sql.PreparedStatement" %>   
        <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Statement" %>
       
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
</head>
<body>
<%
try{
DBmanager db = new DBmanager();
Connection con = db.getConnection();
if(con==null)
{	out.print("connection failed");
}


Statement stmt=con.createStatement();
String sql="DROP table bidder";
String sql1="DROP table additem";
String sql2="DROP table bidderprice";



String sql3="Select name,email from bidder where price=(select MAX(price) from bidder)";
ResultSet res=stmt.executeQuery(sql3);
while(res.next()){
	String name = res.getString("name");
	String email=res.getString("email");
	
	out.print("Winner is "+name+" "+ email);
	
}
Statement stmt1=con.createStatement();
 stmt1.executeUpdate(sql);
 Statement stmt2=con.createStatement();
stmt2.executeUpdate(sql1);
Statement stmt3=con.createStatement();
stmt3.executeUpdate(sql2);


}
catch(Exception e)
{
	out.print("You do not have any items added yet! Add item !!!!!");
}
%>
<s:form  action="additem">
<s:textfield key="item.itemname"></s:textfield>
<s:textfield key="item.itemprice"></s:textfield>
<s:submit key="go" ></s:submit><br/>
</s:form>

</body>
</html>