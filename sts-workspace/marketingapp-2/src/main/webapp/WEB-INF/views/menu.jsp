<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="pb-3">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container bg-dark">
				<a class="navbar-brand" href="#"><i class="fa fa-users"
					aria-hidden="true"></i></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="views">Create
									Registration</a></li>
							<li class="nav-item"><a class="nav-link"
								href="getAllReg">All Registrations</a></li>

							<form class="mr-auto" method="post" action="logout">
								<button class="btn btn-danger" type="submit" value="logout">Logout</button>
							</form>
						</ul>

					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>