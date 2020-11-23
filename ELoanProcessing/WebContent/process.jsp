<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "eloanDB";
String userid = "root";
String password = "root";
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
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page   
	     
	-->
	<jsp:include page="header.jsp"/>   
		<form action="user?action=process" method="POST">
		    <div align="center">
		    <h5><div align="right"><a href="adminhome.jsp">Home</a></div></h5>
		    <h5><div align="right"><a href="index.jsp">Logout</a></div></h5>
		    <label>Enter application number:</label>
		    <input     type="text" name="applno" required/>
		    </div>
		    <div align="center">
		   	<button><a href="calemi.jsp">Process</a></button>
			<button><a href="userhome.jsp">cancel</a></button>
			</div>
		</form>
		<jsp:include page="footer.jsp"/>

</body>
</html>