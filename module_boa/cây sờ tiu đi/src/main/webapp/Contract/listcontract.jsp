<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Contract</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="/css/main.css">


</head>
<body>
<div class="container-fluid">
    <jsp:include page="../header.jsp"/>
    <div id="main" class="row">
        <div class="sidebar col-sm-2">
            sidebar
        </div>
        <div class="bodyarea col-sm-10">
            <h3>Thông tin hợp đồng</h3>
            <a href="/contract?action=create">
                <button class="btn btn-primary">Thêm mới</button>
            </a>
            <div>
                <p>Tìm kiếm hợp đồng</p>
                <form action="/contract?action=find" method="post">
                    <input type="text" name="find" value="${valuefind}" id="find">
                    <input type="submit" value="TÌM KIẾM">
                </form>
            </div>


            <table id="customer" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Mã HĐ</th>
                    <th>Mã DV</th>
                    <th>Tên DV</th>
                    <th>Tên KH</th>
                    <th>Tên NV</th>
                    <th>Ngày BĐ</th>
                    <th>Ngày KT</th>
                    <th>Thanh toán trước</th>
                    <th>Tổng cộng</th>
                    <th>Chi tiết</th>
                    <th>Chỉnh sửa</th>
                    <th>Xóa</th>
                </tr>
                </thead>

                <tbody>
                <c:if test="${empty contractListFind}">
                    <c:forEach items="${contractList}" var="contractlist">
                        <tr>
                            <td>${contractlist.contractId}</td>
                            <td>${contractlist.service.serviceId}</td>
                            <td>${contractlist.service.serviceName}</td>
                            <td>${contractlist.customer.customerName}</td>
                            <td>${contractlist.employee.name}</td>
                            <td>${contractlist.beginDate}</td>
                            <td>${contractlist.finishDate}</td>
                            <td>${contractlist.firstPayment}</td>
                            <td>${contractlist.totalPayment}</td>

                            <td><a href="" class="btn btn-primary" role="button">Detail</a></td>
                            <td><a href="/contract?action=edit&id=${contractlist.contractId}" class="btn btn-warning" role="button">Edit</a></td>
                            <td><a href="#" data-toggle="modal" data-target="#modelDelete" class="btn btn-danger" onclick="onDelete(${contractlist.contractId})" role="button">Delete</a></td>
                        </tr>
                        <!-- Button trigger modal -->
                    </c:forEach>
                </c:if>

                <c:if test="${not empty contractListFind}">
                    <c:forEach items="${contractListFind}" var="contractlistfind">
                        <tr>
                            <td>${contractlistfind.contractId}</td>
                            <td>${contractlistfind.service.serviceId}</td>
                            <td>${contractlistfind.service.serviceName}</td>
                            <td>${contractlistfind.customer.customerName}</td>
                            <td>${contractlistfind.employee.name}</td>
                            <td>${contractlistfind.beginDate}</td>
                            <td>${contractlistfind.finishDate}</td>
                            <td>${contractlistfind.firstPayment}</td>
                            <td>${contractlistfind.totalPayment}</td>

                            <td><a href="" class="btn btn-primary" role="button">Detail</a></td>
                            <td><a href="/contract?action=edit&id=${contractlistfind.contractId}" class="btn btn-warning" role="button">Edit</a></td>
                            <td><a href="#" data-toggle="modal" data-target="#modelDelete" class="btn btn-danger" onclick="onDelete(${contractlistfind.contractId})" role="button">Delete</a></td>
                        </tr>
                    </c:forEach>

                </c:if>
                <!-- Modal Delete -->
                <div class="modal fade" id="modelDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="/contract">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="" id="idContractDelete">
                                <div class="modal-body">
                                    <p id="nameDelete"></p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                </tbody>



            </table>
        </div>
    </div>

    <div id="footer" style="width: 100%;height: 50px;background-color: darkgray;color: white">
        <p>&copy; Codegym Da Nang</p>
    </div>
</div>

<script src="/js/jquery-3.5.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/datatables/js/jquery.dataTables.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.js"></script>

<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            'pageLength': 10
        });
    })
    function Value(idmodal,namemodal,birthdaymodal,idcardmodal,phonenumber,email,typename,address) {
        document.getElementById("idmodal").innerHTML = idmodal;
        document.getElementById("namemodal").innerHTML = namemodal;
        document.getElementById("birthdaymodal").innerHTML = birthdaymodal;
        document.getElementById("idcardmodal").innerHTML = idcardmodal;
        document.getElementById("phonenumbermodal").innerHTML = phonenumber;
        document.getElementById("emailmodal").innerHTML = email;
        document.getElementById("typenamemodal").innerHTML = typename;
        document.getElementById("addressmodal").innerHTML = address;
    }
    function onDelete(idDelete) {
        document.getElementById("idContractDelete").value = idDelete;
        document.getElementById("nameDelete").innerHTML = "Bạn có muốn xóa " + idDelete + " ?";
    }
</script>
</body>
</html>