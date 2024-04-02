<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)request.getAttribute("name");
int total=(int)request.getAttribute("total");
%>
<h1>Thank you <%=name%></h1>
<h2>Total amount : <%=total %></h2>

</body>
</html>