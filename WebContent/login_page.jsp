<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.container{
	display:flex;
	justify-content:center;
	align-items:center;
	top:50%;
	bottom:50%;
	}
</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div class="container">
	<form action="login" method="post" align="center">
	<h1>
	Enter User-name: <input type="text" name="uname"></br>
	Enter password: <input type="password" name="password"></br>
	<input type="submit" value="Submit">
	</h1>
	</form>
	</div>
	
	
</body>
</html>