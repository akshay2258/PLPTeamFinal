<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Header</title>
			<!-- <style type="text/css">
			body {background-image: url("images/Desert
			.jpg");
				background-size: cover;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			}
			</style> -->
		<style>
			ul {
 			position: relative; 
     		top: 0; 
     		width: 100%; 
		    list-style-type: none;
		    margin: 0;
		    padding: 0;
		    overflow: hidden;
		    background-color: #4CAF50;
			}
		
			li {
			    float: left;
			}
			
			li a, .dropbtn {
			    display: inline-block;
			    color: white;
			    text-align: center;
			    padding: 14px 16px;
			    text-decoration: none;
			}
			
			li a:hover, .dropdown:hover .dropbtn {
			    background-color: red;
			}
			
			li.dropdown {
			    display: inline-block;
			}
			
			.dropdown-content {
			    display: none;
			    position: absolute;
			    background-color: #f9f9f9;
			    min-width: 160px;
			    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
			    z-index: 1;
			}
			
			.dropdown-content a {
			    color: black;
			    padding: 12px 16px;
			    text-decoration: none;
			    display: block;
			    text-align: left;
			}
			
			.dropdown-content a:hover {background-color: #f1f1f1}
			
			.dropdown:hover .dropdown-content {
			    display: block;
			}
		</style>
	</head>
	<body>
		<%-- <center>
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
			<center> --%>
			<ul>
				  <li><a href = "getHomePage.do">Home</a></li>
				  <li><a href = "getHomePage.do">Program List</a></li>
				  <li style="float:right" class="dropdown">
				    <a href="javascript:void(0)" class="dropbtn">Contact Us</a>
				    <div class="dropdown-content">
				      <a href="#">Link 1</a>
				      <a href="#">Link 2</a>
				      <a href="#">Link 3</a>
				    </div>
				  </li>
			</ul>
		</center>
	</body>
</html>