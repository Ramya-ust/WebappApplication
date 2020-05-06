<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
      <title>Login Page</title>
   </head>
   
   <body>
      <h1>Login to account</h1>
      <h3>Username:admin  & Password:admin</h3>
      <s:form action = "login">
         <s:textfield key="user.name" ></s:textfield><br/>
         <s:password key="user.password" ></s:password><br/> 
        <s:submit key="submit"> </s:submit>
      </s:form>
   </body>
</html>