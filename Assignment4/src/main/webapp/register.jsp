<%@page import="bean.registerbean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:useBean id="rb" class="bean.registerbean" scope="page" />
	<jsp:setProperty property="firstName" name="rb" param="firstName"/>
	<jsp:setProperty property="lastName" name="rb" param="lastName"/>
	<jsp:setProperty property="email" name="rb" param="email"/>
	<jsp:setProperty property="passwd" name="rb" param="passwd"/>
	<jsp:setProperty property="birth" name="rb" param="birth"/>
	<jsp:setProperty property="status" name="rb" value="0"/>
	<jsp:setProperty property="role" name="rb" value="voter"/>
	<%rb.registerUser(); %>
	<% if(rb.getCount()==1){ %>
		Registered successfully!
		<a href="index.jsp">Sign in</a>
	<%}else{ %>
		Registration failed!
		<a href="newuser.jsp">Sign up</a>
	<%} %>
</body>
</html>