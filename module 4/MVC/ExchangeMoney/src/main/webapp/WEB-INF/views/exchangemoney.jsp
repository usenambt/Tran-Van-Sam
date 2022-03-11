<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/28/2022
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Money</title>
</head>
<body>
<h3>Exchange Money</h3>
<form action="/exchangemoney" method="post">
    <label for="">Rate</label>
    <input type="text" name="rate">
    <br>
    <br>
    <label for="">USD</label>
    <input type="text" name="usd">
    <br>
    <br>
    <input type="submit" value="Converter">

</form>
</body>
</html>
