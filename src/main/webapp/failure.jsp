<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  <h1>User <%= session.getAttribute("userName") %> failed to log in.</h1>
 </div>
 <table>
  <tr>
  	<td><a href="${pageContext.request.contextPath}/login.jsp" >Click here to Login</a></td>
  </tr>
  </table>
</body>
</html>