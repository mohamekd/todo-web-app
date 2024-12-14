<%@ include file="common/header.jspf" %>
<title>Todo Page</title>
</head>
<body>
<%@ include file="common/nav.jspf" %>
<div class="container mb-3">
	<h3>Enter Todo Details :
</div>
<div class="container">
<form:form method="post" modelAttribute="todo">
	
	<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" required="required"/>
		<form:errors path="description" cssClass="text-warning"/>
	</fieldset>
	<fieldset class="mb-3">
		<form:label path="target">Date	</form:label>
		<form:input type="text"  path="target" required="required"/>
		<form:errors path="target" cssClass="text-warning"/>
	</fieldset>
	<form:input type="hidden" path="id" />
	<form:input type="hidden" path="done" />
	<input type="submit" class="btn btn-success">
</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
$('#target').datepicker({
    format: 'yyyy-mm-dd'
});
</script>



