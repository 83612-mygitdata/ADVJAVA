<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Beans</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.bean.RegisterBean"/>
	<jsp:setProperty name="rb" property="firstName" param="firstName"/>
	<jsp:setProperty name="rb" property="lastName" param="lastName"/>
	<jsp:setProperty name="rb" property="email" param="email"/>
	<jsp:setProperty name="rb" property="password" param="passwd"/>
	<jsp:setProperty name="rb" property="birth" param="birth"/>

	<%--<jsp:setProperty name="rb" property="*" /> --%>
	
	<jsp:setProperty name="rb" property="status" value="0" />
	<jsp:setProperty name="rb" property="role" value="voter" />
	
	<% rb.registerUser(); %>
	<% if(rb.getCount() == 1) { %>
		Registration successful.
		<a href="index.jsp">Sign In</a>
	<% } else { %>
		Registration failed.
		<a href="newuser.jsp">Sign Up</a>
	<% } %>
</body>
</html>