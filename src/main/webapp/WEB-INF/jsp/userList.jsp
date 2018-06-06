<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>

<style>
	table{
		background:#000;
		border:0;
	}
	table tr{
		background:#FFF;
	}
	table td{
		text-align:center;
	}
</style>
</head>
<body>
<table>
		<tr>
	        <th>用户名</th>
	        <th>密码</th>
        </tr>
		<c:forEach items="${userList}" var="t">
			<tr>
				<td><c:out value="${t.userName}"></c:out></td>
				<td><c:out value="${t.password}"></c:out></td>
				
			</tr>
		</c:forEach> 
</table>
</body>
</html>