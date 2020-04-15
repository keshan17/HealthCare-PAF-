<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patients' Portal</title>
</head>
<body>
	<h2>Patients' Portal</h2>
	<form method="post" action="patient.jsp">
	<fieldset>
	
		<legend> Create an Appointments </legend>
		Patient NIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
			name="patientNIC"><br> <br> Doctor's Speciality
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="spec"><br>
		<br> Doctor&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
			name="doc"><br> <br> Date <input type="date"
			name="date"> <br> <br> Time <input type="time"
			name="time"> <br> <br> Hospital <input type="text"
			name="hospital"> <br> <br> <input type="submit"
			name="submit" value="Submit"> <br> <br> Appointment
		
	</fieldset>
	</form>
	<br>
	<br>

	<fieldset>
		<legend> Appointments </legend>
		<p id="appointmet">
		
			<span> </span>
		</p>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Delete Appointment</legend>
		<form method="post" action="patient.jsp">
			Appointment Number &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumber"><br> <br> Doctor's Name <input
				type="text" name="appNoUpdate"> <br> <br> <input
				type="submit" name="delete" value="Delete">
		</form>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Update Appointment</legend>
		<form method="post" action="patient.jsp">
			Appointment Number &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumberUpdate"><br> <br> Updated
			Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="upDate"><br>
			<br> Updated Hospital &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="text" name="upHospital"><br> <br> Updated
			Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="upTime"><br>
			<br> <input type="submit" name="update" value="Update">
		</form>

	</fieldset>

	<br>
	<br>
	<form method="post" action="payment.jsp">
	<input type="submit" name="pay" value="To the Payments">
	</form>

</body>
</html>