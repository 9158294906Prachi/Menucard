<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<%= msg %>
<%}
%>
	<form>
		<a href="login.jsp"><input type="button" name="signin" value="Sign in"></a> 
		<a href="resister.jsp"><input type="button" name="signun" value="Sign up"></a>
	</form>
</body>
</html>