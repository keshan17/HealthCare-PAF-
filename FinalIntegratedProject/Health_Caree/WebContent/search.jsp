<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="AdminModel.Admin" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
		String driver = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String database = "newdb";
		String userid = "root";
		String password = "";
		String roll_no=request.getParameter("roll_no");
		try {
		Class.forName(driver);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
		<h1>Search Data</h1>
		<table border="1">
		<tr>
		<td>Name</td>
		<td>Email Id</td>
		<td>Roll No</td>
		</tr>
		
		
		<%
		try{
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement=connection.createStatement();
			String sql ="select * from doctor_details where doc_id="+roll_no+" ";
			resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		%>
			<tr>
			<td><%=resultSet.getString("doc_name") %></td>
			<td><%=resultSet.getString("doc_nic") %></td>
			<td><%=resultSet.getString("doc_email") %></td>
			</tr>
		<%
			}
			connection.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
		%>
		<br>
		<br>
		
</table>
</body>
</html>