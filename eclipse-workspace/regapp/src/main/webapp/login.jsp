<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>
	<link rel="shortcut icon" href="https://ram-cab-new.web.app/favicon.png" type="image/png">

	<!-- Bootstrap CSS CDN -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
		integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<!-- Font Awesome CSS CDN -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
		integrity="sha512-PgQMlq+nqFLV4ylk1gwUOgm6CtIIXkKwaIHp/PAIWHzig/lKZSEGKEysh0TCVbHJXCLN7WetD8TFecIky75ZfQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
	<% 
		
		if(request.getAttribute("error")!= null){
			out.println(request.getAttribute("error"));
		}
	%>
	
	<!-- Login Form -->
	<div class="container">
		<br>
		<div class="card bg-light">
			<span id="mainAlert"></span>
			<article class="card-body mx-auto" style="max-width: 400px; font-size: 1.5rem!important;">
				<h1 class="card-title mt-3 text-center">Login User</h1>
				
				<form id="loginForm" action="verifyLogin" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
						</div>
						<input name="email" id="email" class="form-control" required placeholder="Email address"
							type="email">
					</div>
					
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
						</div>
						<input name="pass" id="pass" class="form-control" required placeholder="Password"
							type="password">
					</div>
										
					<div class="form-group">
						<button id='insertBtn' type="submit" class="btn btn-primary btn-block"> Login </button>
					</div>
				</form>
				
			</article>
		</div> <!-- card.// -->

	</div>

	<footer>
		<!--<p>Created With 🧡 By Lucifer</p> -->
	</footer>

	<!-- Jquery CDN -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
		</script>
	<!-- Bootstrap JS CDN -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous">
	</script>
</body>

</html>