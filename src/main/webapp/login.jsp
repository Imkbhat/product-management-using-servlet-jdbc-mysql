<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% String userCreated = (String)session.getAttribute("userCreated"); %>
</head>
<body>
 <div align="center">
 <c:choose>
  <c:when test="${not empty userCreated}">
   <h3>User <%= session.getAttribute("userCreated") %> have successfully registered. Please login</h3>
  </c:when>
  <c:otherwise>
  <h1>User Login Form</h1>
  </c:otherwise>
 </c:choose>
  <form action="<%=request.getContextPath()%>/login" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="userName" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="userPass" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
  <table>
  <tr>
  	<td><a href="${pageContext.request.contextPath}/register.jsp" >Click here to Register</a></td>
  </tr>
  </table>
 </div>
</body>
</html>