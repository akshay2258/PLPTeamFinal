<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
		<script src="/PLP_UniversityAddmissionSystem_Team4/jsLib/jquery-1.12.3.js" type="text/javascript"></script>
		<script src="/PLP_UniversityAddmissionSystem_Team4/jsLib/MyJsLib.js" type="text/javascript"></script>
		<style type="text/css">
		body {background-image: url("images/Desert
		.jpg");
			background-size: cover;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		}
		</style>
</head>
<body>
<center>
<h1>Welcome to Shukla Group of Institutions</h1>
</center><br/>
<div align="right">
	<c:if test="${loginId eq null}">
			<form action="validateUser.do" >
				<input type="text" name="loginId" placeholder="User Name"> &nbsp
				<input type="text" name="password" placeholder="Password"> &nbsp
				<input type="submit" value="Login">
			</form>
		</c:if>
		<c:if test="${loginId ne null}">
		<h3>Welcome ${role} ${loginId}</h3>
		</c:if>
</div><br><br>
<center>
<a href = "getHomePage.do">Home</a> &nbsp &nbsp &nbsp
<a href = "getHomePage.do">Program List</a> &nbsp &nbsp &nbsp
<a href = "getHomePage.do">Contact Us</a> &nbsp &nbsp &nbsp
</center>
</body>
</html>