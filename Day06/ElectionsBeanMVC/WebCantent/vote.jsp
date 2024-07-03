<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>

	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="vb" class="com.sunbeam.bean.voteBean" scope="session"/>
	
	<jsp:setProperty property="candidateId" name="vb" param="candidate"/>
    <jsp:setProperty property="userId" name="vb" value="${lb.user.id}"/>
    
    ${an.msg}
    <br/><br/>
    <c:choose> 
    	<c:when test="${ lb.user.status==1 }">
    		You have Already Voted!!!
    	</c:when>
    	<c:when test="${ lb.user.status==0 }">
    		${vb.vote()}
    		Thank You for Vote!!!
    	</c:when>
    </c:choose>
    <br/><br/>
    <a href="logout.jsp">Sign Out</a>
    
</body>
</html>