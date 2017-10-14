<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applicant List Page</title>
</head>
<body>
	<form action="MACApplicantListAfterInterview.do">
		<input type="text" name="scheduledProId" required><br>
		<input type="submit" value="Get List">
	</form><br><br>
	<c:if test="${appList ne null}">
		<table width="700" align="center" border="1" bgcolor="#CCCCCC">
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
					<td><a href="MACupdateStatusPage.do?appId=${list.applicationId}">Update Status</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>