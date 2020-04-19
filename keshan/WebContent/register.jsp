<%@page import="RegisterModel.Register" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
if (request.getParameter("nic") != null) 
	{
	Register reg=new Register();
		//reg.connect();
		String stsMsg=reg.getRegistrationInfo(request.getParameter("name"),
				request.getParameter("nic"),
				request.getParameter("email"),
				request.getParameter("pwd"),
				request.getParameter("status"));
	
		

		session.setAttribute("statusMsg", stsMsg);
		response.sendRedirect("loginGui.jsp");
						
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Health Care - Register</title>
</head>
<body>

	<h2>Registration Form</h2>
	<br>
	<br>
	<form method="post" action="register.jsp">
		Name : <input type="text" placeholder="Insert Name" name="name"><br>
		<br> <br> NIC : <input type="text" placeholder="NIC" name="nic"><br>
		<br> <br> E-mail : <input type="text"
			placeholder="E - mail" name="email"><br> <br> <br>
		Password: <input type="password" placeholder="Password" name="pwd"><br>
		<br> <br> <label for="cars">Category : </label> <select
			name="status">
			<option value="patient">Patient</option>
			<option value="doctor">Doctor</option>
			<option value="hospital1">Hospital</option>
		</select> <br> <br> <input  name="register"
			type="submit" value="Register"><br> <br> <br>


	</form>


	<input type="button" name="signin" value="Sign In">

</body>
</html>