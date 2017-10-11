<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<center>
<h1>Welcome to University Admission System</h1>
</center>
<center>
<table>
	<tr>
		<td>
			<a href="sheduledProgramlist.do">Scheduled Programs</a>
		</td>
		<td><a href="allProgramslist.do">All Programs</a>
		</td>
		
		<td>
			<select>
				<option value="login">Apply</option> 
				<option value="getRegisterationPage.do">New User</option>
				<option value="mac">Already Registered</option>
			</select>
			</td>
			<td>
		
			<select name="login" >
			<option value="login">Login</option> 
				<option value="admin">Admin</option>
				<option value="mac">MAC</option>
			</select>
		</td>
	</tr>
</table>
</center>
	<div align="left">
	<a href="getRegisterationPage.do">New Applicant</a><br/>
	<a href="sfs">Already Applied</a>
	</div>

</body>
</html>