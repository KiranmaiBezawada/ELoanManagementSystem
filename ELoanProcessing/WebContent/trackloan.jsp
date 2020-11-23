<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TrackLoan</title>
</head><jsp:include page="header.jsp"/>   
		<form action="user?action=trackloan" method="POST">
		    <div align="center">
		    <h5><div align="right"><a href="userhome.jsp">Home</a></div></h5>
		    <h5><div align="right"><a href="index.jsp">Logout</a></div></h5>
		    <label>Enter application number:</label>
		    <input     type="text" name="applno" required/>
		    </div>
		   <div align="center">
			<button>Track</button>
			<button><a href="userhome.jsp">cancel</a></button>
			</div>
		</form>
		<jsp:include page="footer.jsp"/>
<body>

	

</body>
</html>