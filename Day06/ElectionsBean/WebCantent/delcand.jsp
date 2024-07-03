<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
		<h3>${initParam.appTitle}</h3>
		<jsp:useBean id="dlc" class="com.sunbeam.bean.DeleteCandidateBean"/>
		<jsp:setProperty name="dlc"  property="id" />
		${ dlc.delete() }
		
		<c:choose>
		<c:when test="${dlc.count == 1}">
			Candidate deleted Successfully. <br/><br/>
			<a href="result.jsp">Show Result</a>
			
		</c:when>
		<c:otherwise>
			Candidate delete failed. <br/><br/>
			<a href="result.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>
</body>
</html>