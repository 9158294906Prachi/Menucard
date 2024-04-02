<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="user" method="post">
	Name:<input type="text" name="name">
	<br>
	Phone:<input type="text" name="phone" pattern="[6-9]{1}[0-9]{9}">
	<br>
	Email:<input type="email" name="email">
	<br>
	<button>Resister</button>
	</form>

</body>
</html>