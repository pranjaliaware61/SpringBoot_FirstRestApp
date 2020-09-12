<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
<title>Add TODO</title>
</head>
<body>
<div class="container">
<form:form method="post" class="form-group" modelAttribute="todo">
<h1>Add ToDo</h1>
<fieldset>
<form:label path="desc">Description</form:label>
<form:input type="text" path="desc" class="form-control" required="required"></form:input>
<form:errors path="desc" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="targetDate">Target Date</form:label>
<form:input type="text" path="targetDate" class="form-control" required="required"></form:input>
<form:errors path="targetDate" cssStyle="color: #ff0000;"/>
</fieldset>
<br>
<fieldset>
<form:label path="isDone">isDone</form:label>
<form:input type="text" path="isDone" class="form-control" required="required" disabled="true"></form:input>
<br>
<button type="submit" class="btn btn-success">Add</button>
</fieldset>


</form:form>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	    
	    <script>
	    $('#targetDate').datepicker({
   	    format: 'dd/mm/yyyy'
        });
	    </script>
</body>

</html>