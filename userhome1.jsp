<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loanapply</title>
</head>
<body>
<jsp:include page="header.jsp"/> 
<div align="right"><a href="index.jsp">Logout</a></div>
 <div align="right"><a href="userhome.jsp">Home</a></div> 
    <div align="center">
	<h4>Your loan application is Successfull!</h4>
	<h4>Please note your application number </h4>
	<%@page import="java.sql.*"%>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eloanDB", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT applno FROM loanInfo");
			int id = 0;
			int pid = 0;
			if (rs.last()) {
				pid= rs.getInt("applno");
				id = rs.getInt("applno") + 1;
				%>
				
			<%	
			}
		} catch (Exception e) {
		}
	%>
	
	<div align="center">
	<jsp:include page="footer.jsp"/>
	</body>
</html>