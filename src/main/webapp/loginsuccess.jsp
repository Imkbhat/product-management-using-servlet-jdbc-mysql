<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.prodmgmnt.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>User <%= session.getAttribute("userName") %> have successfully logged in.</h1>
 </div>
 <form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
</form>
 <table style="with: 100%" border="1">
 <tr>
 	<td>Product ID</td>
 	<td>Product Name</td>
 	<td>Delete</td>
 	<td>Edit</td>
 </tr>
 <c:set var="count" value="0" scope="page" />
 <c:forEach items="${products}" var="prod" >
 <c:set var="count" value="${count + 1}" scope="page"/>
    <tr>
    	<td>${count}</td>
        <td>${prod.product_name}</td>
        <td><a href="${pageContext.request.contextPath}/editproduct.jsp?product_name=${prod.product_name}&product_id=${prod.product_id}">Edit</a></td>
        <td><a href="${pageContext.request.contextPath}/deleteproduct.jsp?product_name=${prod.product_name}&product_id=${prod.product_id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<table>
  <tr>
  	<td><a href="${pageContext.request.contextPath}/addproduct.jsp" >Click here to Add a Product</a></td>
  </tr>
  </table>
</body>
</html>