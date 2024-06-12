<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting</title>
</head>
<body>
	<h2>Welcome</h2>
	<form method="post" action="login.jsp">
		Email: <input type="text" name="email"/> <br/><br/>
		Password: <input type="password" name="passwd"/> <br/><br/>
		<input type="submit" value="Sign In"/>
		<a href="newuser.jsp">Sign up</a>
	</form>
</body>
</html>
