<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/5/2022
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form action="/caculator" method="post">
  <table>
    <tr>
      <td>First: </td>
      <td>
        <input type="number" name="a" value="${first}">
      </td>
    </tr>
    <tr>
      <td>Second: </td>
      <td>
        <input type="number" name="b" value="${second}">
      </td>
    </tr>
    <tr>
      <td>Operator: </td>
      <td>
        <select name="operator">
          <option ${add}>+</option>
          <option ${sub}>-</option>
          <option ${multi}>*</option>
          <option ${divv}>/</option>
        </select>
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <button type="submit">Compute</button>
      </td>
    </tr>
    <tr>
      <td>Result: </td>
      <td>
        <input type="number" value="${r}">
      </td>
    </tr>

  </table>
</form>

  </body>
</html>
