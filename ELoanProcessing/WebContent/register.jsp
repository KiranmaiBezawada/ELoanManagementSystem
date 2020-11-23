<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eloan Register</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
	<div align=center>
		<h2>eLoan Register</h2>
		<form action="user?action=registernewuser" method="post">
			<div align="center">
				<label>Username:</label> <input type="text" name="username" required />
			</div>
			<div align="center">
				<p>
					<label>Password:</label> <input type="password" name="password"	required />
				</p>
			</div>
			<div>
				<button>Register</button>
				<button>
					<a href="index.jsp">cancel</a>
				</button>
			</div>

		</form>
	</div>
	</div>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>