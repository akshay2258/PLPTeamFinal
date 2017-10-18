<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="applicantShowStatus.do">
		<input type="text" name="applicationId" required><br>
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
</body>
</html>