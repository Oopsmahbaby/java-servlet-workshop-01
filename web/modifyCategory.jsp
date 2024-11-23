<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Category</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="header.jspf" %>
        <div class="container">

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Categories Name</th>
                        <th>Memo</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.cateList}" var="c">
                        <c:set var="id" value="${c.typeID}"/>
                        <tr>
                            <td>${id}</td>
                            <td>${c.categoryName}</td>
                            <td>${c.memo}</td>
                            <c:if test="${sessionScope.TTDN.account=='admin'}">
                            <td>
                                <a href="updateCate?cID=${c.typeID}" class="btn btn-success">Update</a>
                                <a href="deleteCate?typeID=${c.typeID}" class="btn btn-danger">Delete</a>
                            </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                        <c:set var="ERR_DEL" value="${ERR_DELETE}"></c:set>
                        <c:if test="${not empty ERR_DEL}">
                        <b style="color: red">
                            ${ERR_DEL}
                        </b>
                        </c:if>
                </tbody>
            </table>
        </div>


        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>

    </body>
</html>
