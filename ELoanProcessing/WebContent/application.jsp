<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<body onload="myFunction()">
	<jsp:include page="header.jsp" />
	<form action="user?action=application1" method="POST">
		
		</p>
		<div align="center">
			<label>Loan Name:</label> <input type="text" name="loanname" required />
		</div>
		
		<div align="center">
			<p>
				<label>Loan amount:</label> <input type="number" name="amtrequest"
					required />
			</p>
		</div>
		<div align="center">
			<p>
				<label>Date</label> <input type="text" class="form-control"
					placeholder="dd/mm/yyyy" autocomplete="off" id="datepicker2"
					name="datepicker2" />
			<p id="demo"></p>

			<script>
				function myFunction() {
					var d = new Date();
                   var n = d.toLocaleDateString();
					//SimpleDateFormat
					//formatter = new SimpleDateFormat("yyyy-MM-dd");
					//String 	n = formatter.format(d);

					document.getElementById("datepicker2").defaultValue = n;
					
				}
			</script>

		</div>
		<div align="center">
			<p>
				<label for="bstructuree">Bussiness Structure</label> <select
					name="bstructure" id="BussinessStructure">
					<option value="individual">Individual</option>
					<option value="organisation">Organisation</option>
				</select>
			</p>
		</div>
		<div align="center">
			<p>
				<label for="bindicator">Billing Indicator</label> <select
					name="bindicator" id="BillingIndicator">
					<option value="salaried">Salaried</option>
					<option value="notsalaried">Independent</option>
				</select>
			</p>
		</div>
		<div align="center">
			<p>
				<label for="tIndicator">Tax Indicator</label> <select
					name="tIndicator" id="BillingIndicator">
					<option value="taxpayer">Tax Payer</option>
					<option value="nottaxpayer">Not a Tax Payer </option>
				</select>
			</p>
		</div>

		<div align="center">
			<p>
				<label>Mobile Number</label> <input type="Text" name="mobile"
					required />
			</p>
		</div>

		<div align="center">
			<p>
				<label>EMail</label> <input type="Text" name="email" required />
			</p>
		</div>

		<div align="center">
			<p>
				<label>Address</label> <input type="Text" name="address" required />
			</p>
		</div>

		<div align="center">
			<h1></h1>

			<button>submit</button>
			<button>Clear</button>
		</div>
	</form>
	<jsp:include page="footer.jsp" />

</body>
</html>