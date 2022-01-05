<%--
  Created by IntelliJ IDEA.
  User: TIMT V3
  Date: 10/28/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center"><a href="list">List All Customer</a></h1>
<div align="center">
    <form action="update" method="post">
        <table border="1" cellpadding="5">
            <caption>
                Edit Customer
                <tr>
                    <td>
                        <input type="hidden" name="id" size="45"value="${customer.getId()}">
                    </td>
                </tr>
                <tr>
                    <th>Customer Name: </th>
                    <td>
                        <input type="text" name="name" size="45" value="${customer.getName()}">
                    </td>
                </tr>
                <tr>
                    <th>Customer Phone: </th>
                    <td>
                        <input type="text" name="phone" size="45" value="${customer.getPhone()}">
                    </td>
                </tr>
                <tr>
                    <th>Customer Mail: </th>
                    <td>
                        <input type="text" name="mail" size="45" value="${customer.getMail()}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </caption>
        </table>
    </form>

</div>
</body>
</html>
