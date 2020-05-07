<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Welcome</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>
<body>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("./index.jsp");
    } else {
        session.getAttribute("username");
    }
%>
<div class="container">
    <h2>Welcome, ${username}</h2>
    <form action="logout">
        <input type="submit" class="btn btn-warning btn-md" value="Logout">
    </form>
    <div class="row">
        <div class="row">
            <div class="col-md-9">
                <h3>Choose your dream cat</h3>
            </div>
            <div class="col-md-3">

            </div>
        </div>
        <div id="carousel-example" class="carousel slide hidden-xs" data-ride="carousel">
            <div class="carousel-inner">
                <div class="item active">
                    <div class="row">
                        <!-- Card -->
                        <%--<c:forEach var="product" items="${products}">
                            <div class="col-sm-3">
                                <div class="col-item">
                                    <div class="photo">
                                        <img src="${pageContext.request.contextPath}/images/${product.image}" class="img-responsive" alt="${product.name}"/>
                                    </div>
                                    <div class="info">
                                        <div class="row">
                                            <div class="price col-md-6">
                                                <h5>${product.name}</h5>
                                                <h5 class="price-text-color">$ ${product.price}</h5>
                                            </div>
                                            <div class="rating hidden-sm col-md-6">
                                                <i class="price-text-color fa fa-star"></i><i
                                                    class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i
                                                    class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                            </div>
                                        </div>
                                        <div class="separator clear-left">
                                            <p class="btn-add"><i class="fa fa-shopping-cart"></i><button data-id="${product.idproducts}" class="btn btn-info btn-sm">Add to
                                                cart</button></p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Card -->
                        </c:forEach>--%> <%--Выгрузка товаров из ArrayList--%>
                        <c:forEach var="product" items="${products}">

                            <div class="col-sm-3">
                                <div class="col-item">
                                    <div class="photo">
                                        <img src="${pageContext.request.contextPath}/images/${product.value.image}" class="img-responsive" alt="${product.value.name}"/>
                                    </div>
                                    <div class="info">
                                        <div class="row">
                                            <div class="price col-md-6">
                                                <h5>${product.value.name}</h5>
                                                <h5 class="price-text-color">$ ${product.value.price}</h5>
                                            </div>
                                            <div class="rating hidden-sm col-md-6">
                                                <i class="price-text-color fa fa-star"></i><i
                                                    class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i
                                                    class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                            </div>
                                        </div>

                                        <div class="separator clear-left">
                                            <p class="btn-add"><i class="fa fa-shopping-cart"></i>
                                                <button data-id="${product.key}"
                                                        data-name="${product.value.name}"
                                                        data-price="${product.value.price}"
                                                        data-image="${product.value.image}"

                                                        class="btn btn-info btn-sm add_cart">Add to cart
                                                </button></p>
                                        </div>
                                        <div class="clearfix">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Card -->
                        </c:forEach>

    <div class="container z-depth-1 p-5 my-5">

        <!-- Section: Block Content -->
        <section>

            <!-- Shopping Cart table -->
            <div class="table-responsive">
                <table class="table product-table table-cart-v-1">
                    <!-- Table head -->
                    <thead>
                    <tr>
                        <th></th>
                        <th class="font-weight-bold">
                            <strong>Product</strong>
                        </th>
                        <th></th>
                        <th class="font-weight-bold">
                            <strong>Price</strong>
                        </th>
                        <th class="font-weight-bold">
                            <strong>QTY</strong>
                        </th>
                        <th class="font-weight-bold">
                            <strong>Amount</strong>
                        </th>
                        <th></th>
                    </tr>
                    </thead>
                    <!-- Table head -->
                    <!-- Table body -->
                    <tbody id="body-cart">

                    </tbody>
                    <tr id="body-amount">

                    </tr>
                    <!-- Table body -->
                </table>
            </div>
            <!-- Shopping Cart table -->

        </section>
        <!-- Section: Block Content -->

    </div>
</div>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/basket.js"></script>
</body>
</html>
