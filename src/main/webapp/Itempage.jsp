<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
   <%@page import="com.dao.DBmanager" %>
    <%@page import="java.sql.Connection" %>
     
        <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Statement" %>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item page</title>
</head>
<body>
<h1>Items</h1>
    
      <table align="center"  cellpadding="5"  cellspacing="5"  border="1">
<tr>

</tr>

<tr bgcolor="#A52A2A">
<td><b>itemname</b></td>
<td><b>itemprice</b></td>
</tr>
      <% 
try{
DBmanager db = new DBmanager();
Connection con = db.getConnection();
if(con==null)
{	out.print("connection failed");
}


Statement stmt=con.createStatement();
String sql="Select * from additem";
ResultSet res=stmt.executeQuery(sql);
while(res.next()){
%>
<tr bgcolor="#DE8887">
<td><%=res.getString("itemname") %>    </td>
<td><%=res.getString("itemprice") %>    </td>

</tr>
<%

}

}
catch(Exception e)
{
	e.printStackTrace();
}
%>

</table>
<s:form action="items">
<s:textfield key="bid.bidderprice"></s:textfield>
 <s:submit key="addbid"> </s:submit>
 </s:form>
</body>
</html>