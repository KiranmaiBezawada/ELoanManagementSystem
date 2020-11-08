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
<body>
<form action="user?action=process" method="POST">
<div align="right"><a href="index.jsp">Logout</a></div>
 <div align="right"><a href="adminhome1.jsp">Home</a></div> 
<h1>Details of  Loan applications</h1>
<table border="1">
<tr>
<td>Loan name</td>
<td>Application number</td>
<td>AmountRequested</td>
<td>Bussiness Structure</td>
<td>Billing Indicator</td>
<td>Tax Indicator</td>
<td>Mobile</td>
<td>Email</td>
<td>Status</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select username,loan_name,applno ,amtrequest,applcationdate,bstructure,bindicator,tIndicator,mobile_number,email,address,status from loanInfo where applno=2;";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("loan_name") %></td>
<td><%=resultSet.getString("applno") %></td>
<td><%=resultSet.getString("amtrequest") %></td>
<td><%=resultSet.getString("bstructure") %></td>
<td><%=resultSet.getString("bindicator") %></td>
<td><%=resultSet.getString("tIndicator") %></td>
<td><%=resultSet.getString("mobile_number") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("status") %></td>
</tr>

<%}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</table>
<p>
				<label>Amount Sanctioned</label>
				 <input type="number" name="as" />
			</p>
		
		
			<p>
				<label>Payment start Date</label>
				 <input type="date" name="psd" />
			</p>
			<p>
				<label>Term of loan</label>
				 <input type="number" name="tol" />
			</p>
			<p>
				<label>Interest rate</label>
				 <input type="number" name="ir" />
			</p>
			
			<h4> Term payment amount is ${monthlypayment2}</h4>
		<h4>EMI is ${Termpaymentamount2} </h4>
		
		<button>Calculate EMI</button>
		<button ><a href="adminhome1.jsp"> >Approved<a></button></button>
		<button><a href="adminhome1.jsp">Rejected</a></button></button>
		
			</p>
		

</body>
</html>