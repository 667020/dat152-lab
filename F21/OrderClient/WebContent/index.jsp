<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Client</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

<form method="get" action="sso">
<div id="rcorners">
<h3>eLibrary Book Order Client</h3>
<p><font color="red">${message}</font></p>
<table>
<tr>
<td><h5>ISBN</h5></td>
<td><input type="text" name="isbn" value="" size=20></td>
</tr>
<tr>
<td><h5>Expiry</h5></td><td><input type="text" name="expiry" value="" size=12></td>
</tr>
<!-- 
				<tr>
					<td><h5><fmt:message key="userid" /></h5></td>
					<td><input type="text" name="userid" value="" size=3></td>
				</tr>
 -->
<tr>
<td><input type="hidden" name="response_type" value="code"></td>
<td><input type="hidden" name="scope" value="openid phone profile"></td>
<td><input type="hidden" name="client_id" value="${client_id}"></td>
<td><input type="hidden" name="state" value="${state}"></td>
<td><input type="hidden" name="redirect_uri" value="${redirect_url}"></td>
</tr>
<tr>
<td><input type=submit name="submit" value="Order"></td>
</tr>
</table>
</div>
</form>

</body>
</html>