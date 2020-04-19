<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    
    <%
    	String userid=request.getParameter("username");
    	String password=request.getParameter("password");
    	String status=request.getParameter("status");
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","");
    	Statement st=con.createStatement();
    	ResultSet rs;
    	if(status.equals("patient"))
    	{
    		
    	
    		
        	rs = st.executeQuery("select * from patient_details where patient_nic='" + userid + "' and patient_pwd='" + password + "'");
        	if(rs.next()){
        		session.setAttribute("userid", userid);
        		//out.println("welcome"+userid);
        		//out.println("<a href="logout.jsp">log out</a");
        		response.sendRedirect("patient.jsp");
        	}
        	else{
        		out.println("invalid password<a href='loginGui.jsp'> Try again</a>");
        	}
    	}
    	else if(status.equals("doctor"))
    	{
    		
    	
    		
        	rs = st.executeQuery("select * from doctor_details where doc_nic='" + userid + "' and doc_password='" + password + "'");
        	if(rs.next()){
        		String docNic = request.getParameter(userid);
        		session.setAttribute("userid", userid);
        		out.println("welcome"+userid);
        		//out.println("<a href="logout.jsp">log out</a");
        		response.sendRedirect("doctor.jsp");
        	}
        	else{
        		out.println("invalid password<a href='index.jsp'> Try again</a>");
        	}
    	}
    	else if(status.equals("hospital"))
    	{
    		
    	
    		
        	rs = st.executeQuery("select * from hospital_details where hos_nic='" + userid + "' and hos_password='" + password + "'");
        	if(rs.next()){
        		session.setAttribute("userid", userid);
        		//out.println("welcome"+userid);
        		//out.println("<a href="logout.jsp">log out</a");
        		response.sendRedirect("hospital.jsp");
        	}
        	else{
        		out.println("invalid password<a href='index.jsp'> Try again</a>");
        	}
    	}
    	else if(status.equals("admin"))
    	{
    		
    	
    		
        	rs = st.executeQuery("select * from admin where user_name='" + userid + "' and password='" + password + "'");
        	if(rs.next()){
        		session.setAttribute("userid", userid);
        		//out.println("welcome"+userid);
        		//out.println("<a href="logout.jsp">log out</a");
        		response.sendRedirect("admin.jsp");
        	}
        	else{
        		out.println("invalid password<a href='index.jsp'> Try again</a>");
        	}
    	}

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>