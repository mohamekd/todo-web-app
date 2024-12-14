<%@ include file="common/header.jspf" %>
<title>My Todos</title>
</head>
<body>
<%@ include file="common/nav.jspf" %>
<div class="container">
	<!--
		<br>
		<div>Hello ${name}</div>
		<hr>
		  -->
	<h3>Your Todos List :</h3>
	<table class="table">
		<thead>
			<tr>
				<!--<th>ID</th>-->
				<th>Description</th>
				<th>Target Date</th>
				<th>Completed?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studyTodosList}" var="todo">
				<tr>
					<!--<td>${todo.id}</td>-->
					<td>${todo.description}</td>
					<td>${todo.target}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="newtodo" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="common/footer.jspf" %>
