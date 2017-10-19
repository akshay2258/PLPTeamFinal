<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
	<form action="MACupdateStatusAfterInterview.do">
	<div class="box">
	Application Id : <input type="text" name="appId" value="${appId}" readonly="readonly">
	Enter New Status:<input type="radio" name="status" value="confirmed">Confirmed
					<input type="radio" name="status" value="rejected">Rejected
	<input type="submit" value="Update" class="btn">
	</div>
	</form>
	<c:if test="${successMsg ne null}">
		<h3 align="center" style="color: green;">${successMsg}</h3>
	</c:if>		
		</div>
	</body>
</html>