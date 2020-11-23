<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1 align="center">Welcome</h1>
<h5><div align="right"><a href="index.jsp">Logout</a></div></h5>
<h2><div align="center">
<a href="application.jsp">Apply for Loan</a><br>
</div></h2>
<h2>
<div align="center">
<a href="trackloan.jsp">Track Loan Applicatiion</a><br>
</div></h2>
<h2><div align="center">
<a href="editloan.jsp">Edit Loan Application</a>
</div></h2>
<jsp:include page="footer.jsp"/>
</body>
</html>