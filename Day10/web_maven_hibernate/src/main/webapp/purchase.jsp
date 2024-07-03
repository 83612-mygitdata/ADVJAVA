<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Product</title>
</head>
<jsp:setProperty property="*" name="product_bean" />
<body>
	<c:set var="status"
		value="${sessionScope.product_bean.PurchaseProduct()}" scope="session" />
	<c:redirect url="/" />
</body>
</html>