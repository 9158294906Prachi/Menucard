<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.List"%>
<%@page import="menucard.dto.Menucard"%>
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
<%
LinkedHashSet<Menucard> hashSet= new LinkedHashSet<>((List)request.getAttribute("list"));
%>
<table border="2px" cellspacing="0px">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
	</tr>
	<%
	for(Menucard menucard:hashSet){
	%>
	<tr>
		<td><%=menucard.getMenuId() %></td>
		<td><%=menucard.getName() %></td>
		<td><%=menucard.getPrice() %></td>
		
		<td><a href="add?id=<%=menucard.getMenuId()%>"><button>add</button></a> </td>
		
	</tr>
	<%
	}
	%>
</table>
</body>
</html>