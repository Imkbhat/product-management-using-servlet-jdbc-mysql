<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
 <div align="center">
 <h1>User Registration Form</h1>
<form action="<%=request.getContextPath()%>/Register" method="post">
<table style="with: 100%">
    <tr>
     <td>UserName:</td>
     <td><input type="text" name="userName" /></td>
    </tr>
    <tr>
     <td>Password:</td>
     <td><input type="password" name="userPass" /></td>
    </tr>
    <tr>
     <td>Email Id:</td>
     <td><input type="text" name="userEmail" /></td>
    </tr>
    
    <tr>
     <td>Contact:</td>
     <td><input type="text" name="userContact" /></td>
    </tr>

   </table>
   <input type="submit" value="Register" />
</form>
<table>
  <tr>
  	<td><a href="${pageContext.request.contextPath}/login.jsp" >Click here to Login</a></td>
  </tr>
  </table>
 </div>
</body>
</html>