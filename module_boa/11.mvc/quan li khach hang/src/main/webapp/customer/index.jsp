<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="text-align: center">ALOALOALO</h1>
<h2 style="text-align: center">
    <a href="new">Add new customer</a>
    <a href="list">List all customer</a>

</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caprion><h2>List of Customer</h2></caprion>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td><c:out value="${customer.getId()}"></c:out></td>
            <td><c:out value="${customer.getName()}"></c:out></td>
            <td><c:out value="${customer.getPhone()}"></c:out></td>
            <td><c:out value="${customer.getMail()}"></c:out></td>
            <td>
                <a href="edit?id=<c:out value="${customer.getId()}"></c:out>">Edit</a>
                <a href="delete?id=<c:out value="${customer.getId()}"></c:out>">Delete</a>
            </td>
        </tr>
        </c:forEach>

    </table>

</div>
<br/>

</body>
</html>