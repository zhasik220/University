<%@ page import="java.util.ArrayList" %>
<%@ page import="moduls.Student" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page import="moduls.Admin" %>
<%@ page import="db.DBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp"%>
</head>
<%
    Admin admin= (Admin) session.getAttribute("userType");
%>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-4">
    <form action="/add_student" method="post">
        <div class="row">
            <div class="col-12">
                <label>Full Name : </label>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <input type="text" class="form-control" name="full_name">
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <label>Email : </label>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <input type="text" class="form-control" name="email">
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <label>Password : </label>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <input type="password" class="form-control" name="password">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <button class="btn btn-dark">Add Student</button>
            </div>

        </div>

    </form>
</div>
</body>
</html>
