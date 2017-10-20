<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>University Login Page</title>
  
   <link href="css/styleLogin.css" rel="stylesheet">
<!--       <link rel="stylesheet" href="css/styleLogin.css"> -->

  <style type="text/css">
  	body{
  font-family: 'Open Sans', sans-serif;
  background:#3498db;
  margin: 0 auto 0 auto;  
  width:100%; 
  text-align:center;
  margin: 20px 0px 20px 0px;   
}

	h1{
  font-size:1.5em;
  color:#525252;
}
  
  </style>
</head>

<body>
<form method="post" action="validateUser.do" id="loginform">
<div class="box">
<h1>University Login</h1>
<c:if test="${error ne null}">
	<font color="red"> * ${error}</font>
</c:if>
<input type="text" name="loginId"  onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
  
<input type="password" name="password"  onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />
 
<input type="submit" class="btn" value="Sign In">
<a href="#"><div id="btn2">Sign Up</div></a> <!--End Btn2-->
</div> <!-- End Box -->
  
</form>

</body>
</html>