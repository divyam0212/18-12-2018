<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="../css/hackerrank.css" type="text/css">
	<!-- <script src="../js/validdates.js"></script>  -->
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
				<div id="error"><c:out value="${error }"></c:out></div>
				<form name="loginhr" method="post" action="LoginController"> <!-- onsubmit="validation();" --> 
					<table align="center">
						<tr>
							<td><a href="home" class="btn1">LOGIN</a></td>
							<td><a href="register" class="btn1">SIGNUP</a></td>
						</tr>
						<tr>
							<td colspan="2"><input required="required" data-placement="right"
								class="textbox iconuser" type="text" name="email"
								placeholder="Enter Email ID"></td>
						</tr>
						<tr>
							<td colspan="2"><input required="required" data-placement="right"
								class="textbox iconpass" type="password" name="password"
								placeholder="Enter Password"></td>
						</tr>
						<tr>
							<td colspan="2"><input data-placement="right" class="btn2"
								type="submit" name="submit" value="LOGIN">
						</tr>
						<tr>
							<td colspan="2"><hr></td>
						</tr>
						<tr>
							<td colspan="2">Or connect with:</td>
						</tr>
						<tr>
							<td colspan="2">
								<!-- <a class="btn2" href="">Facebook</a>
							<a class="btn2" href="">Google</a>
							<a class="btn2" href="">LinkedIn</a>
							<a class="btn2" href="">GitHub</a> --> <a class="iconFb" href="">Facebook</a>
								<a class="iconG" href="">Google</a> <a class="iconL" href="">LinkedIn</a>
								<a class="iconGit" href="">GitHub</a>
							</td>
						</tr>
						<tr>
							<td colspan="2"><i style="font-size: medium;">By signing
									up, you agree to our <a href="" class="link">Terms of
										Service</a> and <a href="" class="link"">Privacy Policy.</a>
							</i></td>
						</tr>
					</table>
				</form>
			</div>
	</div>
	<div id="footer">
		<a href="login" class="link">Are you looking for HackerRank for Work?</a>
	</div>
</div>

</body>
</html>

<!-- <a href="loginhr.jsp" class="btn1">LOGIN</a><br>
					<a href="signuphr.jsp" class="btn1">SIGNUP</a><br>
					<input  class="textbox" type="text" name="username" placeholder="Enter UserName or Email"><br>
					<input class="textbox" type="password" name="password" placeholder="Enter Password"><br>
					<input class="btn2"type="submit" name="submit" value="LOGIN"><br> -->

	

				<!--
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
				  -->