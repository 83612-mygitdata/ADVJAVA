<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcement</title>
</head>
<body>
   <jsp:useBean id="an" class="com.sunbeam.bean.AnnouncementBean" scope="application"/>
   <jsp:setProperty property="msg" name="an" param="msg"/>
   <c:redirect url="result.jsp"/>
</body>
</html>