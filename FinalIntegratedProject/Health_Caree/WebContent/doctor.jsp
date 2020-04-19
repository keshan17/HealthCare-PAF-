<%@page import="DoctorModel.Doctor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
if (request.getParameter("docNic") != null) 
	{
		Doctor reg=new Doctor();
		//reg.connect();
		String stsMsg=reg.addSession(request.getParameter("docNic"),
				request.getParameter("specialization"),
				request.getParameter("Hosptial"),
				request.getParameter("Room_No"),
				request.getParameter("datee"),
				request.getParameter("timee"),
				request.getParameter("timee2"));
	
		

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("loginGui.jsp");
						
	}
	
	if (request.getParameter("docId") != null)
	{
		Doctor itemObject = new Doctor();
	 	String stsMsg = itemObject.deleteSession(request.getParameter("docId"));
	 	
	 session.setAttribute("statusMsg", stsMsg);
	} 
	

	 if (request.getParameter("udoctorId") != null) 
	{
		 Doctor update=new Doctor();
		//app.connect();
		String stsMsg=update.updateSession(request.getParameter("udoctorId"),
				request.getParameter("uHosptial"),
				request.getParameter("update_date"),
				request.getParameter("upTime"),  
				request.getParameter("upTime2"),
				request.getParameter("Room_No"));
	
		

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("patient.jsp");
						
	}  
	
	%>
	
	



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors' Portal</title>
<link href="myStyle.css" rel="stylesheet" />
</head>
<body>
	<h2>Doctors' Portal</h2>
	<fieldset>
		<legend>Add Sessions</legend>
		<form method="post" action="doctor.jsp">
				
				Doctor NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="docNic">
				<br> <br>
				
				
				Doctor Specialization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="specialization">
				<br><br>
				
				Hospital &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<select name = "Hosptial">
				<option value = "Suwasewana" selected = "selected">Suwasewana</option>
				<option value = "Nawaloka" selected = "selected">Nawaloka</option>
				<option value = "Asiri" selected = "selected">Asiri</option>
				</select>
				<br> <br>
				
				
				
				
				Room No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<select name = "Room_No">
				<option value = "101" selected = "selected">101</option>
				<option value = "202" selected = "selected">202</option>
				<option value = "303" selected = "selected">303</option>
				</select>
				<br><br>
				
				Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				
				<input type="radio" name="datee" value="Monday">Monday
				<input type="radio" name="datee" value="Tuesday">Tuesday
				<input type="radio" name="datee" value="Wednesday">Wednesday
				<input type="radio" name="datee" value="Thursday">Thursday
				<input type="radio" name="datee" value="Friday">Friday
				
				<br><br>
				
				Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time" 
				name="timee">
				to Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time" 
				name="timee2">
				<br><br>
				
				 Please &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="status">
				<option id="delete">Delete</option>
				<option id="transfer">Transfer</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; this Appointment / to
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumber" placeholder="Transferring Doctor's NIC "><br><br>
				<input type="submit" name="submit" value="Submit">
		</form>
	</fieldset>
	<br>
	<br>
	
	<br>
	<fieldset>
		<legend>Delete Sessions</legend>
		<form method="post" action="doctor.jsp">
				
				Doctor NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="docId">
				<br> <br>
			
				
				<input type="submit" name="submit" value="Submit">
		</form>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Update Sessions</legend>
		<form method="post" action="doctor.jsp">
			Doctor NIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <input type="text"
			 name="udoctorId"><br> <br> 
			 
			  Updated Hospital &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <select name = "uHosptial">
				<option value = "Suwasewana" selected = "selected">Suwasewana</option>
				<option value = "Nawaloka" selected = "selected">Nawaloka</option>
				<option value = "Asiri" selected = "selected">Asiri</option>
				</select>
				<br><br>
			
			Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="update_date">Monday
				<input type="radio" name="update_date">Tuesday
				<input type="radio" name="update_date">Wednsday
				<input type="radio" name="update_date">Thursday
				<input type="radio" name="update_date">Friday
				
			<br><br>
			
				Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input  type ="time" name="upTime">
				To Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input  type ="time" name="upTime2">
				<br>
			<br>
			
			Updated Room No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<select name = "Room_No">
				<option value = "101" selected = "selected">101</option>
				<option value = "202" selected = "selected">202</option>
				<option value = "303" selected = "selected">303</option>
				</select>
				<br><br>
			
			<input type="submit" name="update" value="Update">
		</form>

	</fieldset>
	<fieldset>
		<legend>View session</legend>
		<form method="post" action="doctor.jsp">
		<%
		Doctor viewDoc=new Doctor();
		out.print(viewDoc.readSession());
		%>
		
		
		
		</form>
	</fieldset>
	
</body>
</html>