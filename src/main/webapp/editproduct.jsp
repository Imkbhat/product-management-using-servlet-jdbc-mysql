<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Edit Form</title>
</head>
<body>
 <form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
</form>
 <div align="center">
 <h1>Edit Product</h1>
<form action="<%=request.getContextPath()%>/EditProduct" method="post">
<table style="with: 100%">
    <tr>
     <td>Product Name:</td>
     <td><input type="text" name="prodName" value="${param.product_name}"/>
     	<input type="hidden" name="prodId" value="${param.product_id}"></td>
    </tr>
    <tr>
   </table>
   <input type="submit" value="Update" />
</form>
 </div>
</body>
</html>