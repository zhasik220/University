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
%>
<body>
<%@include file="navbar.jsp"%>
<div>
    <%
        if (student!=null && score==null){
    %>
    <div class="container mt-3">
        <h2 class="fs-1 mb-3">Test</h2>
        <form action="/test" method="post">
            <h5>Question 1: What is the capital city of Kazakhstan?</h5>
            <div class="form-check mt-3">
                <input class="form-check-input" type="radio" name="answer1" id="answerA" value="A">
                <label class="form-check-label" for="answerA">
                    A) Almaty
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="answer1" id="answerB" value="B">
                <label class="form-check-label" for="answerB">
                    B) Astana
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="answer1" id="answerC" value="C">
                <label class="form-check-label" for="answerC">
                    C) Nur-Sultan
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="answer1"  value="D">
                <label class="form-check-label" for="answerD">
                    D) Karaganda
                </label>
            </div>
            <h5 class="mt-3">Question 2: What is the currency of Kazakhstan?</h5>
            <div class="form-check mt-3">
                <input class="form-check-input" type="radio" name="answer2"  value="A">
                <label class="form-check-label" for="answerA">
                    A) Ruble
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="answer2"  value="B">
                <label class="form-check-label" for="answerB">
                    B) Tenge
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="answer2"  value="C">
                <label class="form-check-label" for="answerC">
                    C) Lira
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="answer2" id="answerD" value="D">
                <label class="form-check-label" for="answerD">
                    D) Euro
                </label>
            </div>

            <div class="form-group mt-3 mb-1">
                <h5>Question 3: What is the highest mountain in Kazakhstan?</h5>
                <select class="form-control" name="answer3">
                    <option value="khan_tengri">Khan Tengri</option>
                    <option value="tien_shan">Tien Shan</option>
                    <option value="altai">Altai</option>
                    <option value="pamir">Pamir</option>
                </select>
            </div>
            <div class="form-group mt-3 mb-1">
                <h5>Question 4: Which lake is shared by Kazakhstan and Russia?</h5>
                <select class="form-control" name="answer4">
                    <option value="caspian_sea">Caspian Sea</option>
                    <option value="aral_sea">Aral Sea</option>
                    <option value="balkhash">Lake Balkhash</option>
                    <option value="zaysan">Lake Zaysan</option>
                </select>
            </div>
            <div class="form-group mt-3 mb-1">
                <h5>Question 5: What is the main religion of Kazakhstan?</h5>
                <select class="form-control"  name="answer5">
                    <option value="islam">Islam</option>
                    <option value="christianity">Christianity</option>
                    <option value="buddhism">Buddhism</option>
                    <option value="judaism">Judaism</option>
                </select>
            </div>
            <div class="form-group mt-3 mb-1">
                <h5>Question 6: Which city is known as the "oil capital" of Kazakhstan?</h5>
                <select class="form-control"  name="answer6">
                    <option value="atyrau">Atyrau</option>
                    <option value="aktau">Aktau</option>
                    <option value="karaganda">Karaganda</option>
                    <option value="astana">Astana</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </form>
    </div>
    <%
        }
        else {
            response.sendRedirect("/student");
        }
    %>
</div>
</body>
</html>
