<%-- 
    Document   : addNewCategory
    Created on : Mar 1, 2024, 9:06:23 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Category</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    <body>
        <%@include file="header.jspf" %>
        <form action="addCate" method="post">
        <div class="container">
            <c:if test="${sessionScope.TTDN.account=='admin'}">
                <h1>Add New Category</h1>
                <div class="input-group mb-3">
                    <span class="input-group-text">Category Name</span>
                    <input type="text" class="form-control" placeholder="Enter Category Name" name="cateName">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Memo</span>
                    <input type="text" class="form-control" placeholder="Enter Memo" name="memo">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </c:if>
            <c:if test="${sessionScope.TTDN.account!='admin'}">
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
