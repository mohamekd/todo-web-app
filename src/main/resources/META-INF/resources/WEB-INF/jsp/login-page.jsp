<html>
<head>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">

<title>Login</title>
</head>
<body>
	<div class="container">
		<!--  
			Hello ${name}, you need to Log in at first !
		-->
		<h3>Login!</h3>
		<br>
		<form method="post">
			Enter Username:<input type="text" name="name"> <br>
			Enter Password:<input type="password" name="password"> <br>
			<input type="submit">
		</form>
	</div>
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>