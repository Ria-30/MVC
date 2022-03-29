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
if(session.getAttribute("username")==null)
{
	response.sendRedirect("login_page.jsp");
}

%>
<pre><h1 align="center">Welcome to the First Page,<%= session.getAttribute("username") %> </h1></pre>
<h1>To get the student details Click the button below</h1></br>
<form action="display" method="post" align="center">
<input type="submit" value="CLICK ME"></br>
</form>
&nbsp;
<form action="logout" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>