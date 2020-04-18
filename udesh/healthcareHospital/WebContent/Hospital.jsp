<%@page import="HospitalModel.Hospital" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
if (request.getParameter("hospital") != null) 
	{
		Hospital reg=new Hospital();
		//reg.connect();
		String stsMsg=reg.createHospital(request.getParameter("hospital"),
				request.getParameter("License"),
				request.getParameter("number"),
				request.getParameter("Enumber"),
				request.getParameter("facilities"),
				request.getParameter("roomNo"));
	
		//String sports[]=request.getParameterValues("facilities");
		

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("loginGui.jsp");
						
	}
 
	if (request.getParameter("Eenumber") != null)
	{
		Hospital itemObject = new Hospital();
	 	String stsMsg = itemObject.deleteHospital(request.getParameter("Eenumber"));
	 	
	 session.setAttribute("statusMsg", stsMsg);
	} 
	
	 if (request.getParameter("uLicense") != null) 
	{
		Hospital update=new Hospital();
		//app.connect();
		String stsMsg=update.updateHospital(request.getParameter("uLicense"),
				request.getParameter("unumber"),
				request.getParameter("uEnumber"),
				request.getParameter("ufacilities"),  
				request.getParameter("uroomNo"));
	
		

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("patient.jsp");
						
	}  
	
    %>
    
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Portal</title>
<link href="myStyle.css" rel="stylesheet" />
</head>
<body>
	<h2>Hospital Portal</h2>
	<fieldset>
		<legend>Add Hospital Details</legend>
		<form method="post" action="hospital.jsp">
				
				Hospital Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="hospital">
				<br> <br>
				
				
				License Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="License">
				<br><br>
				
				Telephone Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="number">
				<br><br>
				
				Emergancy Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="Enumber">
				<br><br>
				
				Facilities&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="text" name="facilities">
				
				<br><br>
				
				
				Add Room Numbers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="text" name="roomNo">
				
				<br><br>
		
				<input type="submit" name="submit" >
		</form>
	</fieldset>
	<br>
	<br>
	
	<br>
	<fieldset>
		<legend>Delete Details</legend>
		<form method="post" action="hospital.jsp">
				
			Telephone Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="tnumber">
				<br><br>
				
				Emergancy Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="Eenumber">
				<br><br>
				
				Room Numbers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="text" name="roomNo">
				<br><br>
				<input type="submit" name="submit" value="Submit">
		</form>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Update Details</legend>
		<form method="post" action="hospital.jsp">
	
				License Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="uLicense">
				<br><br>
						 
			 	Updated Telephone Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="unumber">
				<br><br>
				
				Updated Emergancy Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" 
				name="uEnumber">
				<br><br>
				
				Update Facilities&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="text" name="ufacilities">
				
				<br><br>
				
				
				Updated Room Numbers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="text" name="uroomNo">
			<br><br>
			<input type="submit" name="update" >
		</form>

	</fieldset>
</body>
</html>