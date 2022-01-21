<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add Contract</title>
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
            <h3>Thêm mới hợp đồng</h3>
            <form action="/contract?action=create" method="post" class="form-group">
                <table class="table">
                    <tr>
                        <td width="15%">Ngày bắt đầu</td>
                        <td width="30%"><input type="date" name="begindate" class="form-control" id="begindate"></td>
                        <td width="15%">Ngày kết thúc</td>
                        <td width="30%"><input type="date"  name="finishdate" class="form-control" id="finishdate"></td>
                    </tr>
                    <tr>
                        <td width="15%"><label for="">Dịch vụ</label></td>
                        <td>
                            <select name="serviceid" id="" class="custom-select">
                                <c:forEach items="${serviceList}" var="servicelist">
                                    <option value="${servicelist.serviceId}">${servicelist.serviceName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label for="">Khách hàng</label></td>
                        <td>
                            <select name="customerid" id="" class="custom-select">
                                <c:forEach items="${customerList}" var="customerlist">
                                    <option value="${customerlist.customerId}">${customerlist.customerName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="">Thanh toán trước</label></td>
                        <td><input type="text" name ="firstpayment" class="form-control"></td>
                        <td><label for="">Tổng tiền</label></td>
                        <td><input type="text" name="totalpayment" class="form-control"></td>
                    </tr>

                    <tr>
                        <td><label for="">Nhân viên</label></td>

                        <td>
                            <select name="employeeid" id="" class="custom-select">
                                <c:forEach items="${employeeList}" var="employeelist">
                                    <option value="${employeelist.employeeId}">${employeelist.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <input class="btn btn-primary" type="submit" value="Thêm mới"></td>
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