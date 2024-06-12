<%@page import="Pojos.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates</title>
</head>
<body>
	<h3>Online Voting</h3>
 	<jsp:useBean id="lb" class="bean.loginbean" scope="session"/>
 	Hello, <jsp:getProperty name="lb" property="email"/> <hr/>
	<jsp:useBean id="clb" class="bean.CandidateListBean"/>
	<% clb.fetchCandidates(); %>
	<form method="post" action="vote.jsp">
		<% for(Candidate c : clb.getCandidateList()) { %>
			<input type="radio" name="candidate" value="<%= c.getId() %>"/> <%= c.getName() %> - <%= c.getParty() %> <br/>
		<% } %>
		<br/> <input type="submit" value="vote"/>
	</form>
</body>
</html>