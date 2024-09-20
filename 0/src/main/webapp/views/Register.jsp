<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/0/register" method="post" >
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="pass" required> <label
				for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="email"><b>Fullname</b></label> <input type="text"
				placeholder="Enter fullname" name="fullname" required> <label
				for="phone"><b>Phone</b></label> <input type="text"
				placeholder="Enter fullname" name="phone" required>
			<button type="submit">Register</button>
		</div>
	</form>
</body>
</html>