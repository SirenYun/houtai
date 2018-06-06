<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户</title>
</head>
<body>
	<form action="./selectUser" method="post">
		<input type="text" name="uname" placeholder="输入用户名"><br><br>
		<input type="text" name="password" placeholder="输入密码"><br><br>
		<input type="submit" value="submit">
	</form>
	
	<br>
	<c:if test="${empty user }">
		此用户不存在！
	</c:if>
						  
    <c:if test="${not empty user}">
    	<c:out value="${user.userName}"></c:out>
    	<c:out value="${user.password}"></c:out>
    </c:if>

</body>
</html>