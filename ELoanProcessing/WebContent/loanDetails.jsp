<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eloan Details</title>
</head>
<body>
<form action="user?action=trackloan" method="POST">

	<div align="center">
		    <label>Enter Application Number:</label>
		    <input     type="text" name="applno" required/>
		    </div>
		    
		    
		    <div align="center">
		<p>
			<label for="question">choose your Question</label> <select
				name="question" id="question">
				<option value="child">what is your childhood friend name</option>
				<option value="pet">what is your pet mane</option>
			</select>
		</p>
	</div>
	<div align="center">
		    <label>Answer :</label>
		    <input     type="text" name="answer" required/>
		    </div>
		    
		    
		   <button>submit</button>

</body>
</html>