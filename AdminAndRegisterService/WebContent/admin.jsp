<%@page import="AdminModel.Admin" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
if (request.getParameter("nic") != null) 
	{
		Admin reg=new Admin();
		//reg.connect();
		String stsMsg=reg.createEmployees(request.getParameter("name"),
				request.getParameter("nic"),
				request.getParameter("email"),
				request.getParameter("pwd"),
				request.getParameter("status"));
	
		

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("loginGui.jsp");
						
	}
	if (request.getParameter("nic") != null)
	{
		Admin itemObj2 = new Admin();
	 	String stsMsg = itemObj2.deleteEmployee(request.getParameter("nic"),
			 request.getParameter("status"),
			 request.getParameter("status2"));
	 	
	 session.setAttribute("statusMsg", stsMsg);
	}
	if (request.getParameter("unic") != null) 
	{
		Admin update=new Admin();
		//app.connect();
		String stsMsg=update.updateEmployees(request.getParameter("appoitnmentNumberUpdate"),
				request.getParameter("upDate"),
				request.getParameter("upHospital"),
				request.getParameter("upTime"),
				request.getParameter("update_status")
				
				);
	
		

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("patient.jsp");
						
	}
	
%>
	
	
<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>Administration</title>
</head>
<body>
	<div class="container">
	<form class="form-inline" method="post" action="search.jsp">
		<input type="text" name="roll_no" class="form-control" placeholder="Search roll no..">
		<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>
	</div>


	<h2>Administration</h2>
	<br>
	<br>

	<fieldset>
		<legend>Available Doctors</legend>
		<p>
		<%
	 	Admin newAdmin= new Admin();
		 out.print(newAdmin.readDoctors());
		%>
		
		</p>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Appointments</legend>
		<p>
		<%
	 	Admin newobj= new Admin();
		 out.print(newobj.readAppointment());
		%>
		
		</p>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Available Hospitals</legend>
		<p>
		<%
	 	Admin newobj2= new Admin();
		 out.print(newobj2.readHospitals());
		%>
		
		</p>
	</fieldset>
	<br>
	<br>

	<fieldset>
	<form method="post" action="admin.jsp">
		<legend>Create and Delete</legend>
		<select name="status2">
			<option value="create">Create</option>
			<option value="delete">Delete</option>
		</select> &nbsp;&nbsp; a &nbsp;&nbsp; <select name="status">
			<option value="patient">Patient</option>
			<option value="doctor">Doctor</option>
			<option value="hospital1">Hospital</option>
			<option value="appointment">appointment</option>
		</select> <br> <br> Name <input type="text" name="name"> <br>
		<br> NIC <input type="text" name="nic"> <br> <br>
		Email <input type="email" name="email"> <br> <br>
		Password <input type="password" name="pwd"> <br> <br> <input
			type="submit" name="submitDet" value="Execute">
			</form>
	</fieldset>
	<br>
	<br>
	<fieldset>
		<legend>Update Appointment</legend>
			<select name="update_status">
			<option value="patient">patient</option>
			<option value="docotor">doctor</option>
			<option value="hospital">hospital</option>
		</select>
		<br><br>
		<form action="">
			Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="uname"><br> <br> Updated
			Nic &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="unic"><br>
			<br> Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="text" name="uemail"><br> <br> password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="upassword"><br>
			<br> <input type="submit" name="update" value="Update">
		</form>

	</fieldset>
	<br>
	<br>
	<fieldset>
		<legend>Transfer</legend>
		<form>
			Appointment Number &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumber"><br> <br> Doctor
			NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="docNIC"><br>
			<br> Please Transfer this Appointment to
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumber" placeholder="Transferring Doctor's NIC "><br>
			<br> <input type="submit" name="submit" value="Submit">
		</form>
	</fieldset>
</body>
</html>