<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link rel="shortcut icon" href="https://ram-cab-new.web.app/favicon.png"
	type="image/png">

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<!-- Font Awesome CSS CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>User Data</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>City</th>
				<th>Action</th>
			</tr>
			</thead>
			
			<%ResultSet result = (ResultSet) request.getAttribute("user_info");
			while (result.next()) {%>
			<tr>
				<td><%=result.getString(1)%></td>
				<td><%=result.getString(2)%></td>
				<td><%=result.getString(3)%></td>
				<td><%=result.getString(4)%></td>
				<td>
					<a class="pr-2 text-danger" href="delete?email=<%=result.getString(2)%>"><i class="fa fa-trash" aria-hidden="true"></i></a>
					<a class="pl-2 text-primary" href="update?email=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>"><i class="fa fa-edit" aria-hidden="true"></i></a>
				</td>
				
			</tr>
	
			<%}%>
		</table>
	</div>
	<footer>
		<!-- <p>Created By Lucifer</p> -->
	</footer>

	<!-- Jquery CDN -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous">
		
	</script>
	<!-- Bootstrap JS CDN -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous">
		
	</script>
</body>
</html>