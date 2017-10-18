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
	
	<form action="MACupdateStatus.do">
	Application Id : <input type="text" name="appId" value="${appId}" readonly="readonly">
	Enter New Status:<input type="text" name="status"><br>
	<input type="submit" value="Update">
	</form>
	<c:if test="${status eq 'accepted'}">
		<form action="MACupdateDateOfInterview.do?appId=${appId}">
		Application Id : <input type="text" name="appId" value="${appId}" readonly="readonly">
		Enter Date of Interview For Accepted Applicants:<br>
		<input type="text" name="doi">
		<input type="submit" value="Update">
		</form>
	</c:if>
	<c:if test="${status ne 'accepted'}">
		<h3>${successMsg}</h3>
	</c:if>
	
</body>
</html>