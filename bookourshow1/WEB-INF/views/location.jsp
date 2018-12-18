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

<form name="location" method="post" action="LocationController">
<label>Select Location</label>
<select class="dropdown" name="address">
	<c:forEach items="${addressList }" var="address">
		<option value="${address.city.cityId}">${address.city.cityName}</option>
	</c:forEach>
</select>
<input type="submit" name="submit" value="submit"><br>
</form>
</body>
</html>