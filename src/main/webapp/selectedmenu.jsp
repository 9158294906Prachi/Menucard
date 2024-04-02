<%@page import="java.util.ArrayList"%>
<%@page import="menucard.dto.Menucard"%>
<%@page import="java.util.List"%>
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
List<Menucard> menulist=(List)request.getAttribute("list");
int total=0;
%>


<table border="2px" cellspacing="0px">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
	</tr>
	<%
	for(Menucard menu:menulist){
		total+=menu.getPrice();
	%>
	<tr>
		<td><%=menu.getMenuId() %></td>
		<td><%=menu.getName() %></td>
		<td><%=menu.getPrice() %></td>
		<td><a href="remove?id=<%=menu.getMenuId()%>"><button>remove</button></a> </td>
	</tr>
	<%
	}
	%>
</table>

<a href="log"><button>Add more menu</button></a> <br>

Total:<button id="total"><%=total%></button>
<br>
<br>

<a href="saveOrder?total=<%=total%>"><button>Place Order</button></a><br>
</body>
</html>