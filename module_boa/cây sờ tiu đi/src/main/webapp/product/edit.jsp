
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/product?action=update" method="post">
        <div class="form-group">
            <label for="nameProduct">Tên sản phẩm</label>
            <input type="text" class="form-control" id="nameProduct" value="${product.nameProduct}" name="nameProduct" required  minlength="5" maxlength="50">
            <c:if test="${yeuquai != null}">
                <p style="color: red">${yeuquai}</p>
            </c:if>

        </div>
        <div class="form-group">
            <label for="price">Giá</label>
            <input type="number" class="form-control" id="price" value="${product.price}" name="price" required >
            <c:if test="${errPrice != null}">
                <p style="color: red">${errPrice}</p>
            </c:if>
        </div>
        <div class="form-group">
            <label for="status">Trạng thái</label>
            <select class="form-control" id="status" name="status" required>
                <option ${product.status ? 'selected':''} value="true">Còn hàng</option>
                <option ${product.status ? '':'selected'} value="false">Hết hàng</option>
            </select>
        </div>
        <div class="form-group">
            <label for="idCategory">Danh mục</label>
            <select class="form-control" id="idCategory" name="idCategory" required>
                <c:forEach items="${listCategory}" var="category">
                    <option value="${category.idCategory}">${category.nameCategory} </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<a href="/" class="btn btn-success">back</a>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
