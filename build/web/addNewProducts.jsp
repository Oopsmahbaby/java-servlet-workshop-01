<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Products</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    <body>
        <%@include file="header.jspf" %>
        <form action="addProduct" method="post">
        <div class="container">
            <c:if test="${sessionScope.TTDN.roleInSystem=='1'}">
                <h1>Add New Products</h1>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Product ID</span>
                    <input type="text" class="form-control" placeholder="Enter Product ID" name="productId" required>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Product Image</span>
                    <input type="text" class="form-control" placeholder="Enter Product Image" name="productImage">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Product Name</span>
                    <input type="text" class="form-control" placeholder="Enter Product Name" name="productName" required>
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Brief</span>
                    <input type="text" class="form-control" placeholder="Enter Brief" name="brief">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Posted Date</span>
                    <input type="date" class="form-control" placeholder="Enter Posted Date" name="postedDate">
                </div>
                
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Product Type ID</span>
                    <select class="form-select" name="productTypeID" required>
                        <c:forEach items="${requestScope.cateListP}" var="c">
                            <option value="${c.typeID}">${c.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                
                
                <!--<div class="input-group mb-3">-->
                    <!--<span class="input-group-text">Account</span>-->
                    <!--<select class="form-select" name="productAccount" required>-->
                        <%--<c:forEach items="${requestScope.accountListP}" var="o">--%>
                            <!--<option value="${o.account}">${o.account}</option>-->
                        <%--</c:forEach>--%>
                    <!--</select>-->
                <!--</div>-->
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Account</span>
                    <input type="text" class="form-control" placeholder="Enter Posted Date" name="productAccount" value="${sessionScope.TTDN.account}" readonly="">
                </div>
                
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Unit</span>
                    <input type="text" class="form-control" placeholder="Enter Unit" name="unit">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Price</span>
                    <input type="text" class="form-control" placeholder="Enter Price" name="price" value="0">
                </div>
                
                <div class="input-group mb-3">
                    <span class="input-group-text">Discount</span>
                    <input type="text" class="form-control" placeholder="Enter Discount" name="discount" value="0">
                </div>
                
                <c:set var="ERR" value="${ERR_Num}"></c:set>
                <c:if test="${not empty ERR}">
                    <b style="color: red; display: block; margin-bottom: 10px;">
                        ${ERR}
                    </b>
                </c:if>
                
                <button type="submit" class="btn btn-primary mb-3">Submit</button>
                
            </c:if>
            <c:if test="${sessionScope.TTDN.roleInSystem!='1'}">
                <div class="container mt-3">
                    <h2>Alerts</h2>
                    <div class="alert alert-danger">
                        You have <strong>No Permission</strong> to use this function!
                    </div>
                </div>
            </c:if>
        </div>
        </form>
    </body>
</html>
