<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Catalogs</title>
</head>
<body>
	<p><jsp:include page="SetupLanguage.jsp" /></p>
	<fmt:setBundle basename="no.hvl.dat152.i18n.BookDesc" var="msg" />
	<fmt:setBundle basename="no.hvl.dat152.i18n.Config" var="config" />
		
		<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
		<fmt:message key="today" bundle="${config}">
			<fmt:param>
				 <fmt:formatDate value="${now}" />
			</fmt:param>	
		</fmt:message>
	
		<h1 style="text-align: center;margin-top:10px"><fmt:message key="home-pg-title" bundle="${config}"/></h1>
		<div style="margin-top:20px"></div>
		<form>
			<table style="border: 1px solid black;margin-left: auto;margin-right: auto; width: 100%; width:1000px">
				<tr>
					<th></th>
					<th style="width:70%"><h2><fmt:message key="desc" bundle="${config}"/></h2></th>
					<th style="width:10%"></th>
				</tr>
				<c:forEach var="book" items="${books}">
					<tr>
					<td><img src="imgs/${book.icon}" width="170" height="210"></td>
					<td>
						<div style="width:600px; word-wrap: break-word">
							<fmt:message key='${book.isbn}' bundle="${msg}"/>
						</div>
					</td>
					<td>
						<a href=/orderclient/order.jsp?isbn=${book.isbn}> <fmt:message key="link" bundle="${config}"/></a>
					</td>
					</tr>
				</c:forEach>	
			</table>
		</form>
</body>
</html>