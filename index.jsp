<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan system</title>
</head>
	<body>
		<jsp:include page="header.jsp"/>   
		<form action="user?action=validate" method="POST">
		    <div align="center">
		    <label>Username:</label>
		    <input     type="text" name="username" required/>
		    </div>
		    <div align="center">
		    <p><label>Password:</label>
			<input type="password" name="password" required/></p>
			</div>
			<div align="center">
			<h1></h1>
			<p>New User?<a href="register.jsp" align="center" > Register here </a></p>
			<button>submit</button>
			<button>Clear</a></button>
			</div>
		</form>
		<jsp:include page="footer.jsp"/>		
	</body>
</html>