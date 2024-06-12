<%@page import="bean.loginbean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="bean.loginbean" scope="session" />
	<jsp:setProperty property="*" name="lb"/>
	<%--<jsp:setProperty property="password" name="lb" param="passwd"/> --%>
	<%lb.authenticate(); %>
	<%if(lb.getUser()!=null){ %>
		<%if(lb.getUser().getRole().equals("voter")){ %>
			<%response.sendRedirect("candlist.jsp"); %>
			
		<%}else{ %>
			<jsp:forward page="result.jsp" />
		<%} %>
	<%}else{ %>
		<h3>Online voting!</h3>
		Hello, <jsp:getProperty name="lb" property="email"/> <br/>
		Invalid email or password. <br/><br/>
		<a href="index.jsp">Login Again</a>
	<% } %>
		
</body>
</html>