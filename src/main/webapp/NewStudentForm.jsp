<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Student Page</title>
</head>
<style>
.entryFrm{
	border: 1px solid black;
	width: 590px;
}
</style>
<body>
	<h2>Enter new reord</h2>
	<div class="entryFrm" align="center">
		<br>
		<br>
		<form method="post" action="studentSubmit">
			Student's name :&nbsp;&nbsp;&nbsp;<input name="sName" /> <br> <br> Student's
			subject:&nbsp;&nbsp;<input name="sSubject" />
			<br>
			<br>
			<button id="button1">enter</button>
			<br>
			<br>
		</form>
	</div>
	<br>
	<a href="index.jsp">back</a>
</body>
</html>