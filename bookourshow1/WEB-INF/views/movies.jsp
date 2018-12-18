<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="${error }"></c:out>
<c:out value="${cityId }"></c:out>
<c:forEach items="${movieList }" var="movieCategory">
<a href="dispdetail?movieId=${movieCategory.movie.movieId}&cityId=${cityId }">${movieCategory.movie.movieName}</a>
<c:out value="${movieCategory }"></c:out>
</c:forEach>
</body>
</html>