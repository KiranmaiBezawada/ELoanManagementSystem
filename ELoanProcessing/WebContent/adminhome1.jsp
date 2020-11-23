<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin home</title>
</head>
<body>
<form action="admin?action=listall" method="POST">
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<h4><div align="center">Welcome</h4></div>
<h2><div align="center">
<button>List All</button><br>
</div></h2>
<h2>
<div align="center">
<a href="process.jsp">Process Loan</a><br>
</div></h2>
<jsp:include page="footer.jsp"/>
</body>
</html>