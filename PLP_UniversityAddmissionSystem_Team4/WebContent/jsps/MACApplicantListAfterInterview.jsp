<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>MAC Home Page</title>
		 <link href="css/style.css" rel="stylesheet">
		 <link href="css/styleLogin.css" rel="stylesheet">
	<style type="text/css">
	   	body{
	   		background-image:url("images/bgImage.jpg");
	   	}
	   </style>
	<!-- js -->
	<script type="text/javascript" src="js/classie.js"></script>
	<script>
	    function init() {
	        window.addEventListener('scroll', function(e){
	            var distanceY = window.pageYOffset || document.documentElement.scrollTop,
	                shrinkOn = 300,
	                header = document.querySelector("header");
	            if (distanceY > shrinkOn) {
	                classie.add(header,"smaller");
	            } else {
	                if (classie.has(header,"smaller")) {
	                    classie.remove(header,"smaller");
	                }
	            }
	        });
	    }
	    window.onload = init();
	</script>
		<script type="text/javascript">
			window.history.forward();
			function noBack(){
				window.history.forward();
			}
		
		</script>
	</head>
	<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
	<header>
	    <div class="container clearfix">
	        <h1 id="logo">
	            Shukla Group of Institutions
	        </h1>
	         
	        <nav>
	            <a href = "MACHomePage.do">Home</a>
	            <a href = "#">About SGI</a>
	            <a href = "#">Contact Us</a>
<!-- 	            <a href = "getHomePage.do" onclick="noBack()">Log Out</a> -->
				<a href = "getHomePage.do" onclick="noBack()">Log Out</a>
	        </nav>
	        </div>
	</header><!-- /header -->
				<div id="leftside">
				<br><br><br><br><br><br><br>
					<ul class="cl-menu">
		<li>
			<a href="MACApplicantsListPage.do">Update Status of Applied Applicants</a>
		</li>
		 <li>
		<a href="MACApplicantListAfterInterviewPage.do">Update Status of Accepted Applicants After Interview</a>
		</li>
		</ul>
		</div>
		<div id="rightside">
		<br><br><br><br><br><br>
		<c:if test="${appListError ne null }">
			<h3 align="center" style="color: red;">${appListError}</h3><br>
		</c:if>
		<c:if test="${flag ne null}">
			<form action="MACApplicantListAfterInterview.do" id="loginform">
		<div class="box">
				<h1>Enter Program Id</h1>
			<input type="text" name="scheduledProId" pattern="[A-Z][A-Z0-9][0-9]{1,3}" title="Not a valid format. Correct Format (e.g, MG101 or E1)" required><br>
			<input type="submit" class="btn" value="Get List">
		</div>
	</form><br><br>
	</c:if>
	<c:if test="${appList ne null}">
		<table width="700" align="center" border="1">
			<tr>
				<th>Application Id</th>
				<th>Applicant Name</th>
				<th>Date Of Birth</th>
				<th>Highest Qualification</th>
				<th>Marks Obtained</th>
				<th>Goals</th>
				<th>Email Id</th>
				<th>Status</th>
				<th>Date Of Interview</th>
				<th>Update</th>
			</tr>
			<c:forEach var="list" items="${appList}">
				<tr>
					<td>${list.applicationId}</td>
					<td>${list.fullName}</td>
					<td>${list.dateOfBirth}</td>
					<td>${list.highestQualification}</td>
					<td>${list.marksObtained}</td>
					<td>${list.goals}</td>
					<td>${list.emailId}</td>
					<td>${list.status}</td>
					<td>${list.dateOfInterview}</td>
					<td><a href="MACupdateStatusAfterInterviewPage.do?appId=${list.applicationId}">Update Status</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
			
		</div>
	</body>
</html>