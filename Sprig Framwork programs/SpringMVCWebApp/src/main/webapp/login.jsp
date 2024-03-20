<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page with Get method </h2>
<form action="loginCheck" method="get">
	<label>EmailId</label>
	<input type="email" name="emailid"/><br/>
	<label>Password</label>
	<input type="password" name="password"/><br/>
	<input type="submit" value="signin"/>
	<input type="reset" value="reset"/>
</form>
<hr/>
<h2>Login Page with Post method </h2>
<form action="loginCheck" method="post">
	<label>EmailId</label>
	<input type="email" name="emailid"/><br/>
	<label>Password</label>
	<input type="password" name="password"/><br/>
	<input type="submit" value="signin"/>
	<input type="reset" value="reset"/>
</form>
</body>
</html>

