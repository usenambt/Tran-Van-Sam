
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container">
    <a href="/product?action=create" class="btn btn-success">Thêm mới</a>
    <form action="/product" method="get">
        <input name="action" value="search" hidden>
        <input type="text" name="nameSearch">
        <button class="btn btn-success">Tìm kiếm</button>
    </form>
    <table id="product" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Mã sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Giá</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Danh mục</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td> ${product.idProduct}</td>
                <td> ${product.nameProduct}</td>
                <td> ${product.price}</td>
                <td> ${product.status ? 'Còn hàng': 'Hết hàng'}</td>
                <td> ${product.nameCategory}</td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="setValueForm('${product.idProduct}')"
                            data-toggle="modal" data-target="#modalDelete">
                        Xoá
                    </button>

                    <a href="/product?action=edit&id=${product.idProduct}">
                        <button class="btn btn-warning">Sửa</button>
                    </a>
                    </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form method="post" action="/product?action=delete">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <input name="idProduct" id="idProduct" hidden>

                        Bạn có chắc muốn xoá ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                        <button type="submit" class="btn btn-danger" >Xoá</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="/assert/jquery/jquery-3.5.1.min.js"></script>
    <script src="/assert/bootstrap413/js/popper.min.js"></script>
    <script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
    <script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
    <script>
        $(document).ready(function () {
            $('#product').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 3
            })
        })
    </script>
    <script>
        function setValueForm(idProduct) {
            document.getElementById("idProduct").value = idProduct;
        }
    </script>
</div>
</body>
</html>
