<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Confirmation</title>
</head>
<body>
	<table>
		<tr><td>Content</td><td><textarea name=order rows=4 cols=60>"${resource}"</textarea></td></tr>
		<tr><td><a href="order.jsp">Order Page</a></td></tr>
	</table>
</body>
</html>