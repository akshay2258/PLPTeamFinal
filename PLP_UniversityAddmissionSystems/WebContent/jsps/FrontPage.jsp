<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Front Page</title>
<style type="text/css">
			body {
				background-image: url("images/frontpage.jpg");
				background-position: right top;
				margin-right: 200px;
			}
			</style>
</head>
<body>
<jsp:include page="Header.jsp">
			<jsp:param value="${loginId}" name="loginId"/>
		</jsp:include>
</body>
</html>