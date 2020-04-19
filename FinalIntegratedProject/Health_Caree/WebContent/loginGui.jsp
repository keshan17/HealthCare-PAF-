<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<form method="post" action="login.jsp">
		NIC <input type="text" name="username"> <br>
		<br> Password <input type="password" name="password"> <br>
		State 
		<select  name="status">
			<option value="patient">Patient</option>
			<option value="doctor">Doctor</option>
			<option value="hospital">Hospital</option>
			<option value="admin">Admin</option>
		</select>
		<br> <input type="submit"  name="logIn">
	</form>
</body>
</html>