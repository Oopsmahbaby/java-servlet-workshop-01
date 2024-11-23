<%-- 
    Document   : updateAccount
    Created on : Apr 21, 2024, 12:35:22 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
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
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
            }
            * {
                box-sizing: border-box
            }

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            hr {
                border: 1px solid #f1f1f1;
                margin-bottom: 25px;
            }

            /* Set a style for all buttons */
            button {
                background-color: #04AA6D;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }

            button:hover {
                opacity:1;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                padding: 14px 20px;
                background-color: #f44336;
            }

            /* Float cancel and signup buttons and add an equal width */
            .cancelbtn, .signupbtn {
                float: left;
                width: 50%;
            }

            /* Add padding to container elements */
            .container {
                padding: 16px;
            }

            /* Clear floats */
            .clearfix::after {
                content: "";
                clear: both;
                display: table;
            }

            /* Change styles for cancel button and signup button on extra small screens */
            @media screen and (max-width: 300px) {
                .cancelbtn, .signupbtn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <%@include file="header.jspf" %>
        <form action="updateAcc" method="post" style="border:1px solid #ccc">
            <div class="container">
                <h1>Update</h1>
                <p>Please fill in this form to update an account.</p>
                <hr>

                <label for="fname"><b>First Name</b></label>
                <input type="text" placeholder="Enter First Name" name="fname" value="${updAccount.firstName}" required>

                <label for="lname"><b>Last Name</b></label>
                <input type="text" placeholder="Enter Last Name" name="lname" value="${updAccount.lastName}">

                <div class="form-group mb-4">
                    <label for="dob"><b>Birthday</b></label>
                    <input type="date" class="form-control" placeholder="Enter Birthday" name="dob" value="${updAccount.birthday}" required="">
                </div>

                <p class="mb-3 fw-bold">Gender</p>
                <div class="form-check mb-3 fw-bold">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" value="${updAccount.gender}" name="gender" id="maleRadio" checked>
                        <label class="form-check-label" for="maleRadio">Male</label>
                    </div>

                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" value="${updAccount.gender}" name="gender" id="femaleRadio">
                        <label class="form-check-label" for="femaleRadio">Female</label>
                    </div>
                </div>

                <label for="phone"><b>Phone</b></label>
                <input type="text" placeholder="Enter Phone Numbers" name="phone" value="${updAccount.phone}">

                <div class="form-check mb-3 fw-bold">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" value="${updAccount.isUse}" id="activate" name="isUse" checked>
                        <label class="form-check-label" for="active">Activate</label>
                    </div>

                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" value="${updAccount.isUse}" id="deactivate" name="isUse">
                        <label class="form-check-label" for="deactive">Deactivate</label>
                    </div>
                </div>

                <p class="mb-3 fw-bold">Role in System</p>

                <div class="form-check mb-3 fw-bold">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" value="${updAccount.roleInSystem}" id="admin" name="role" onclick="showAdminCode()">
                        <label class="form-check-label" for="admin">Admin</label>
                    </div>

                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" value="${updAccount.roleInSystem}" id="others" name="role" onclick="hideAdminCode()" checked>
                        <label class="form-check-label" for="others">Others</label>
                    </div>
                </div>

                <div class="form-group" id="adminCodeField" style="display:none;">
                    <label for="adminCode"><b>Admin Code</b></label>
                    <input type="text" class="form-control" placeholder="Enter Admin Code" name="adminCode">
                </div>

                <script>
                    function showAdminCode() {
                        document.getElementById('adminCodeField').style.display = 'block';
                    }

                    function hideAdminCode() {
                        document.getElementById('adminCodeField').style.display = 'none';
                    }
                </script>
                
                <label for="account"><b>Account</b></label>
                <input type="text" placeholder="Enter Account" name="account" value="${updAccount.account}" readonly="">
                
                <c:set var="ERR" value="${ACC_Exist}"></c:set>
                <c:if test="${not empty ERR}">
                    <b style="color: red; display: block; margin-bottom: 10px;">
                        ${ERR}
                    </b>
                </c:if>

                <label for="pass"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="pass" value="${updAccount.pass}" required>

                <label for="pass-repeat"><b>Repeat Password</b></label>
                <input type="password" placeholder="Repeat Password" name="pass-repeat" value="${updAccount.pass}" required>
                
                <c:set var="ERR" value="${ERR_PASS}"></c:set>
                <c:if test="${not empty ERR}">
                    <b style="color: red; display: block; margin-bottom: 10px;">
                        ${ERR}
                    </b>
                </c:if>
                
                

                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                </label>

                <!--<p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>-->

                <div class="clearfix">
                    <button type="reset" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Update</button>
                </div>
            </div>
        </form>

    </body>
</html>

