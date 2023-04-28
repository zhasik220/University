<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp"%>
    <script src="https://kit.fontawesome.com/f0c7f2b8a5.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-4">
    <h1 class="mb-4 text-center">Welcome to the Website</h1>
    <form method="get" action="/login">
        <div class="row text-bg-light border border-opacity-50 rounded-top py-1">
            <h2>LogIn Page</h2>
        </div>
        <div class="row border border-opacity-50 rounded-bottom border-top-0">
            <div class="my-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                <div class="col-10">
                    <input type="email" class="form-control" id="staticEmail" name="email">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Password</label>
                <div class="col-10">
                    <div class="input-group">
                        <input type="password" class="form-control" name="password" id="password">
                        <button type="button" class="btn btn-outline-secondary" onclick="togglePasswordVisibility()">
                            <i class="bi bi-eye-slash-fill" id="eye-icon"></i>
                        </button>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <div class="col-3">
                    <button type="submit" class="btn btn-dark">Login</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function togglePasswordVisibility() {
        const passwordInput = document.getElementById("password");
        const eyeIcon = document.getElementById("eye-icon");
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            eyeIcon.classList.remove("bi-eye-slash-fill");
            eyeIcon.classList.add("bi-eye-fill");
        } else {
            passwordInput.type = "password";
            eyeIcon.classList.remove("bi-eye-fill");
            eyeIcon.classList.add("bi-eye-slash-fill");
        }
    }
</script>
</body>
</html>
