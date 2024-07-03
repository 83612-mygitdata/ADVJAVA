<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcement</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	<form method="post" action="AnnBean.jsp">
		Announcement: <br/>
		<textarea name="msg" rows="6" cols="80"></textarea>
		<br/><br/>
		<input type="submit" value="Announce"/>
	</form>
</body>
</html>