<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register</title>
	</head>
	<body>
			<jsp:include page="Header.jsp"></jsp:include>
			<center><h1>${pageHead }</h1></center><br><br>
			<c:if test="${appId ne 0}">
			<h3>You are successfully registered. Your Application Id is ${appId}</h3>
			</c:if>
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
		<center><a href="home.do"></a></center>
	</body>
</html>