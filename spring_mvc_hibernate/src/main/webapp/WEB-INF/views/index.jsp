<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h5>
		Welcome To Spring MVC Rutuja !!!
	</h5>
	<c:url var="url" value="/test/multiply?num1=123&num2=456"/>
	<a href="${url}">Test Model Map With Request Parameter</a>
	<h5>
		<c:url var="url" value="/posts/view?categoryName=category1"/>
		<a href="${url}">List Blog Post By Category Name</a>
	</h5>
</body>
</html>