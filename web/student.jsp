<%@ page import="java.util.ArrayList" %>
<%@ page import="moduls.Student" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="head.jsp"%>
</head>

<%
    Student student= (Student) session.getAttribute("userType");
    Integer score= (Integer) session.getAttribute("score");
    System.out.println("ANSWER::: "+score);
%>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-4">
    <div class="text-center">
        <h1>Welcome <%=student.getFull_name()%></h1>
    </div>
    <%
        if (student!=null && score==null){
    %>
    <div class="container">
        <div class="row">
            <div class="mx-auto col-3 mt-5">
                <a class="btn btn-dark mx-auto w-100" href="/test">Pass test</a>
            </div>
        </div>
    </div>
    <%
        }
        else {
    %>
    <div class="text-center">
        <h2>You already passed the test</h2>
        <h2 class="text-primary">You're score: <%=score%>/6</h2>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
