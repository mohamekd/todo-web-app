<%@ include file="common/header.jspf" %>
<title>Login Again</title>
</head>
<body>
	<div class="container">
		<pre>${err}</pre>
		<br>
		<form method="post">
			Enter Username:<input type="text" name="name"> <br>
			Enter Password:<input type="password" name="password"> <br>
			<input type="submit">
		</form>
	</div>
<%@ include file="common/footer.jspf" %>