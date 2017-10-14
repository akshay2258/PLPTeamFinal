<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>MAC Home Page</title>
	</head>
	<body>
	<jsp:include page="Header.jsp">
			<jsp:param value="${loginId}" name="loginId"/>
		</jsp:include>
		<a href="MACApplicantsListPage.do">Update Status of Applied Applicants</a> <br><br>
		<a href="MACApplicantListAfterInterviewPage.do">Update Status of Accepted Applicants After Interview</a><br><br>
	</body>
</html>