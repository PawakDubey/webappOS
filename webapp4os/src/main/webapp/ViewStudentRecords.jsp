<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="java.util.List,com.openshift.test.db.DBService,com.openshift.test.dto.StudentDetails,java.util.Iterator"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
	<h3>Student Details page</h3>
	<%List<StudentDetails> students = DBService.getStudents(); %>
	<%if(students.size()>0){ %>
	<table style="width:100%">
	<tr>
    	<th>Student Id</th>
    	<th>Student Name</th> 
    	<th>Subject</th>
  	</tr>
  	<tr>
	<%
		
		Iterator<StudentDetails> studentItr = students.iterator();
		while (studentItr.hasNext()) {
			StudentDetails student = studentItr.next();
			out.println("<tr><td>" + student.getStudentId()+"</td>"+"<td>"+ student.getStudentName() +"</td>"+ "<td>" + student.getStudentSubject() + "</td></tr>");
		}
	%>
	</table>
	<%}else{out.println("<h4>No records found. Go back to index page to insert new record</h4>"); }%>
	
<a href="index.jsp">back</a>
</body>
</html>