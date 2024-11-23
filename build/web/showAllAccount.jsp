<%-- 
    Document   : showAllAccount
    Created on : Feb 29, 2024, 9:56:07 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Account</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    <body>
        <%@include file="header.jspf" %>
        <div class="container">

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Account</th>
                        <th>Full Name</th>
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Role In System</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.accountList}" var="c">
                        <%--<c:set var="id" value="${c.typeID}"/>--%>
                        <tr>
                            <td>${c.account}</td>
                            <td>${c.lastName=='0' || empty c.lastName? '': c.lastName} ${c.firstName}</td>
                            <td>${c.birthday=='0' || empty c.birthday? 'None': c.birthday}</td>
                            <td>${c.gender? 'Male' : 'Female'}</td>
                            <td>${c.phone=='0' || empty c.phone? 'None': c.phone}</td>
                            <td>${c.roleInSystem == 1 ? 'Administrator' : 'Staff'}</td>
                            <c:if test="${sessionScope.TTDN.account=='admin'}">
                                <td> 
                                    <div><a href="updateAcc?acc=${c.account}" class="btn btn-success">Update</a></div>

                                </td>
                                <td>
                                    <div><a href="deleteAcc?acc=${c.account}" class="btn btn-danger">Delete</a></div>
                                </td>
                            </c:if>
                        </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
