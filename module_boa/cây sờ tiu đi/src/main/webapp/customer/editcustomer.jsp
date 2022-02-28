<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Edit Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <link rel="stylesheet" href="../css/main.css">
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../header.jsp"/>
    <div id="main" class="row">
        <div class="sidebar col-sm-2">
            sidebar
        </div>
        <div class="bodyarea col-sm-10">
            <h3>Chỉnh sửa khách hàng</h3>
            <form action="/customer?action=edit" method="post" class="form-group">
                <table  class="table">
                    <tr>
                        <td width="15%"><label for="">Mã khách hàng</label></td>
                        <td width="30%"><input type="text" name="idcustomer" value="${customer.customerId}" class="form-control" readonly="readonly" ></td>
                        <td width="15%"><label for="">Họ tên khách hàng</label></td>
                        <td width="30%"><input type="text" name="namecustomer" value="${customer.customerName}" class="form-control" ></td>
                    </tr>
                    <tr>
                        <td><label for="">Ngày sinh</label></td>
                        <td><input type="text" name="birthday" value="${customer.birthday}" class="form-control"></td>
                        <td><label for="">Số CMND</label></td>
                        <td><input type="text" name ="idcard" value="${customer.idCard}" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="">Địa chỉ</label></td>
                        <td><input type="text" name="address" value="${customer.address}" class="form-control"></td>
                        <td><label for="">Số điện thoại</label></td>
                        <td><input type="text" name="phonenumber" value="${customer.phoneNumber}"  class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="">Email</label></td>
                        <td><input type="text" name="email"  value="${customer.email}" class="form-control"></td>
                        <td><label for="">Loại khách hàng</label></td>
                        <td>
                            <select name="customertype" class="custom-select">
                                <c:forEach items="${customerTypeList}" var="customertypelist">
                                    <option value="${customertypelist.customerTypeId}"
                                            <c:if test="${customertypelist.customerTypeId==customer.customerType.customerTypeId}">
                                                selected
                                            </c:if>
                                    > ${customertypelist.customerTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td></td>
                        <td> <input class="btn btn-primary" type="submit" value="CẬP NHẬT"></td>
                    </tr>

                </table>
            </form>
        </div>
    </div>

    <div id="footer" style="width: 100%;height: 50px;background-color: darkgray;color: white">
        <p>&copy; Codegym Da Nang</p>
    </div>
</div>
</body>
</html>