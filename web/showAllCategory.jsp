<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
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
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.cateList}" var="c">
                        <c:set var="id" value="${c.typeID}"/>
                            <tr>
                                <td>${id}</td>
                                <td>${c.categoryName}</td>
                                <td>${c.memo}</td>
                            </tr>
                        
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>

    </body>
</html>
