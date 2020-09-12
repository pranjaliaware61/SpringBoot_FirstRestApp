<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
	    		
<style>
h1
{
text-align: center;
}
</style>
</head>
<body>
<div class="container">
<form method="post">
<h1>ToDo Login</h1>
<fieldset class="form-group">
<label>Username:</label>
<input type="text" name="username" class="form-control" required="required">

<label>Password:</label>
<input type="password" name="password" class="form-control" required="required">
<br>
<button type="submit" class="btn btn-success">Login</button>
</fieldset>
</form>
</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>