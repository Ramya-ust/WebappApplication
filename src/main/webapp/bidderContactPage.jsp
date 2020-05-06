<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
   <%@page import="com.dao.DBmanager" %>
    <%@page import="java.sql.Connection" %>
     <%@page import="java.sql.Statement" %>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bidder Entry page</title>
</head>
<body>

<s:form action="contact" >
<s:textfield key="userBean.name"  />
<s:textfield key="userBean.email"  />
<s:textfield key="userBean.phone"  />
<s:textfield key="userBean.address" />
<s:submit key="submit" />

</s:form>



</body>
</html>