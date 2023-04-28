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
    <h1>Welcome Admin <%=admin.getFull_name()%></h1>
    <br>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Score</th>
        <th>Progress</th>
        <th>Date</th>
        </thead>
        <tbody>
        <%

            ArrayList<Student> students= (ArrayList) request.getAttribute("students");
            for (int i = 0; i < students.size(); i++) {
                double score = students.get(i).getScore() != null ? students.get(i).getScore() : 0.0;
                int progress = (int) (score * 100 / 6);
        %>
        <tr>
            <td><%=students.get(i).getId()%></td>
            <td><%=students.get(i).getFull_name()%></td>
            <td><%=students.get(i).getEmail()%></td>
            <td><%=students.get(i).getPassword()%></td>
            <td><%=students.get(i).getScore()!=null ? score:"Didn't Pass Yet"%></td>

            <td>
                <div class="progress">
                    <%
                        String progressColor="success";
                        if (progress>=50 && progress<70){
                            progressColor="primary";
                        }
                        else if (progress<50){
                            progressColor="danger";
                        }
                    %>
                    z
                </div>
            </td>
            <td><%=students.get(i).getDate()!=null ? students.get(i).getDate():"Data Not Found"%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
