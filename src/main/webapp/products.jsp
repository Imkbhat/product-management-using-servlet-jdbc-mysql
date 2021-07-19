<%@page import="java.util.Iterator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>



</script>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
 <form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
</form>
<div align="center">
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

</div>
 
</body>
</html>