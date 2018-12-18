<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="../css/hackerrank.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hacker Rank</title>
</head>
<body>

<div id="container">
	<div id="header">
		<img src="https://hrcdn.net/hackerrank/assets/brand/typemark_60x200-80fdae47b3b14df04f5300a7b30281cb.png">
	</div>
	<div id="content">
			<div id="main">
				<form name="success" method="get" action="logout">
				WELCOME TO HACKER RANK!!<br>
				REMEMBER YOUR EMAIL ID FOR FUTURE<br>
				EMAIL ID: <c:out value="${user.emailId}"> </c:out><br>
					<input class="btn3" type="submit" name="submit" value="LOGOUT">
				</form>
			</div>
	</div>
	<!-- <div id="footer">
		<a href="loginhr.jsp" class="link">Are you looking for HackerRank for Work?</a>
	</div> -->
</div>

</body>
</html>