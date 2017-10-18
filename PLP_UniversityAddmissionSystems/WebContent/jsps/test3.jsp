<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	
	<!-- title and meta -->
	<!-- <meta charset="utf-8" /> -->
	<meta name="viewport" content="width=device-width,initial-scale=1.0" />
	<meta name="description" content="" />
	<title>University Page</title>
	    
	<!-- css -->
	 <link href="css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,700,400italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
	   <style type="text/css">
	   	body{
	   		background-image:url("images/frontpage.jpg");
	   	}
	   	.textadj{
	   		position: absolute;
	   		top:300px;
	   		right: 70px;
	   		padding: 1px;
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
	function ClearHistory()
	{
		function noBack(){
			location.replace();
			window.location="";
		}
	}
	
	</script>
	</head>
	<body>
	<div class="textadj">
	<h1><i>"A place of light,</i></h1><br>
	<h2><i>of liberty,</i></h2><br>
	<h3><i>And of learning."</i></h3><br>
	</div>
	<div id="wrapper">
	<header>
	    <div class="container clearfix">
	        <h1 id="logo">
	            Shukla Group of Institutions
	        </h1>
	         
	        <nav>
	            <a href = "getHomePage.do" >Home</a>
	            <a href = "#">About SGI</a>
	            <a href = "#">Contact Us</a>
	            <a href = "getLoginHomePage.do">Log In</a>
	        </nav>
	        </div>
	</header><!-- /header -->
		<div id="main">
				<div id="leftside">
				<br><br><br><br><br><br><br>
			<!-- <a href="applicantSheduledProgramlist.do">Programs</a> <br><br>
			<a href="applicantShowStatusPage.do">Programs By Location</a><br><br>
			<a href="applicantSheduledProgramlist.do">Apply Online</a><br><br>
			<a href="applicantShowStatusPage.do">Check Application Status</a><br><br> -->
			<ul class="cl-menu">
		<li>
			<a href = "applicantSheduledProgramlist.do">Programs</a>
		</li>
		<li id='albumes'>
			<a href = "#">Programs By Location</a>
			<ul>
				<li>
					<a href="applicantSheduledProgramlistbyLocation.do?location=Mumbai">Mumbai</a>
				</li>
				<li>
					<a href="applicantSheduledProgramlistbyLocation.do?location=Banglore">Banglore</a>
				</li>
				<li>
					<a href="applicantSheduledProgramlistbyLocation.do?location=Delhi">Delhi</a>
				</li>
				<li>
					<a href="applicantSheduledProgramlistbyLocation.do?location=Pune">Pune</a>
				</li>
			</ul>
		</li>
			<li>
				<a href="applicantSheduledProgramlist.do">Apply Online</a>
			</li>
			<li>
				<a href="applicantShowStatusPage.do">Check Application Status</a>
			</li>	
		</ul>
			</div>
			<div id="rightside">
		<c:if test="${scheduledProgramList ne null}">
			<table width="700" border="1">
				<tr>
					<th>Scheduled Program Id</th>
					<th>Program Name</th>
					<th>Location</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Session Per Week</th>
					<th>Apply Online</th>
				</tr>
				<c:forEach var="sch" items="${scheduledProgramList}">
					<tr>
						<td>${sch.scheduledProgramId}</td>
						<td>${sch.programName}</td>
						<td>${sch.location}</td>
						<td>${sch.startDate}</td>
						<td>${sch.endDate}</td>
						<td>${sch.sessionPerWeek}</td>
						<td><a href="getApplicantRegisterationPage.do?schId=${sch.scheduledProgramId}">Apply Online</a></td>
					</tr>
				</c:forEach>
			</table>
			</c:if>
			<c:if test="${statusFlag ne null }">
				<form action="applicantShowStatus.do">
			Enter Application Id : <input type="text" name="applicationId" required><br>
			<input type="submit" value="Get Status">
		</form><br><br>
		<c:if test="${applicant ne null}">
			<table border="1">
				<tr>
					<th>Status</th>
					<td>${applicant.status}</td>
				</tr>
			<c:if test="${applicant.status eq 'accepted'}">
				<tr>
					<th>Date Of Interview</th>
					<td>${applicant.dateOfInterview}</td>
				</tr>		
			</c:if>
			</table>
		</c:if>
		</c:if>
		<c:if test="${applyFlag ne null}">
		<c:if test="${appId ne 0}">
				<h3>You are successfully registered. Your Application Id is ${appId}</h3>
				</c:if>
				<c:if test="${appId eq 0}">
				<sf:form modelAttribute="applicant" action="applicantRegister.do" method="post" >
					<table align="center" border="1">
					
					<tr>
							<td>Program Id :</td>
							<td> <sf:input path="scheduledProgramId" type="text" value="${scheduledId}" readonly="true"/></td>
						</tr>
					
						<tr>
							<td>Enter Full Name :</td>
							<td> <sf:input path="fullName" type="text" required="true" placeholder="e.g.Vipul Gupta"/>
							<sf:errors path="fullName" name="error"></sf:errors></td>
						</tr>
						
						<tr>
							<td>Enter Date Of Birth: </td>
							<td><sf:input path="dateOfBirth" type="text" required="true" />
							<sf:errors path="dateOfBirth" name="error"></sf:errors></td>
						</tr>
						
						<tr>
							<td>Enter Highest Qualification: </td>
							<td><sf:input path="highestQualification" type="text" required="true" placeholder="e.g. B.Tech"/>
							<sf:errors path="highestQualification" name="error"></sf:errors></td>
						</tr>
						<tr>
							<td>Enter Marks Obtained: </td>
							<td><sf:input path="marksObtained" type="text" required="true" placeholder="e.g. 98"/>
							<sf:errors path="marksObtained" name="error"></sf:errors></td>
						</tr>
						<tr>
							<td>Enter Goals: </td>
							<td><sf:input path="goals" type="text" required="true" placeholder="e.g. CEO"/>
							<sf:errors path="goals" name="error"></sf:errors></td>
						</tr>
						
						<tr>
							<td>Enter EmailId:</td>
							<td> <sf:input path="emailId" type="text" required="true" placeholder="e.g. abc@some.some"/>
							<sf:errors path="emailId" name="error"></sf:errors></td>
						
						</tr>
						<tr>
							<td><input  type="reset" value="Reset" /></td>
							<td><input  type="submit" value="Register" /></td>
						</tr>
					</table>
				</sf:form>
				</c:if>
		</c:if>
		</div>
			</div>
			</div>
	</body>
</html>