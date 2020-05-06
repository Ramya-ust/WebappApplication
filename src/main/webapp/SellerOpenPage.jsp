<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
   <%@page import="com.dao.DBmanager" %>
    <%@page import="java.sql.Connection" %>
        <%@page import="java.sql.ResultSet" %>
        <%@page import="java.sql.Statement" %>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller OpenPage</title>
</head>
<body>
<h1>Seller Open page</h1>

Welcome  <s:property value="user.name"/><br>

<%
Connection con= null;
%>
<table align="center"  cellpadding="5"  cellspacing="5"  border="1">
<tr>

</tr>

<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>name</b></td>
<td><b>email</b></td>
<td><b>phone</b></td>
<td><b>address</b></td>
<td><b>item</b></td>
<td><b>price</b></td>
</tr>

<% 
try{
DBmanager db = new DBmanager();
 con = db.getConnection();
if(con==null)
{	out.print("connection failed");
}


Statement stmt=con.createStatement();
String sql="Select * from bidder";
ResultSet res=stmt.executeQuery(sql);
while(res.next()){
%>
<tr bgcolor="#DE8887">
<td><%=res.getString("id") %>    </td>
<td><%=res.getString("name") %>    </td>
<td><%=res.getString("email") %>    </td>
<td><%=res.getString("phone") %>    </td>
<td><%=res.getString("address") %>    </td>
<td><%=res.getString("item") %>    </td>
<td><%=res.getString("price") %>    </td>
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
<s:form action="closebid">
 <s:submit key="button"> </s:submit>
 </s:form>
</body>
</html>