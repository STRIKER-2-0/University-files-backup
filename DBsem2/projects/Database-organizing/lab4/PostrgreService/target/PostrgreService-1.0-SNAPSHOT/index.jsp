<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=cp1251" %>
<%@ page pageEncoding="cp1251" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title> Microblog </title>
    <link href="${pageContext.request.contextPath}/libs/bootstrap.min.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" >
</head>
<body>
    <nav class="navbar navbar-fixed-top header" >
        <div class="header_content" >
            <div> My super Microblog </div>
        </div>
    </nav>

    <div class="content" style="text-align:center" >
        <form method = "POST" action = "" id = "form" class = "form" >
            <input type="hidden" name="type" value="postForm" >
            <input type="text" name="userName" placeholder="Enter your name here... " maxlength="20" class="username" required >
            <textarea form="form" type="text" name="text" placeholder="Enter text here... " maxlength="140" rows="5" class="post_text" required > </textarea>
            <input type="submit" class="btn btn-default send_button" value="Send" >
        </form>
        <c:forEach items="${posts}" var="post" >
        <div class="post" >
            <div class="post_header" >
                <div class="name"> User ${post.userName}</div>
                <div class="date"> ${post.date}</div>
            </div>
            <div class="post_body" >
            <div class="text"> ${post.text}</div>
            </div>
        </div>
        </c:forEach>

        <c:set var="postsPerPage" value="${postsPerPage}"/>
        <form method= "GET" class="paginationForm" >
            <ul class="pagination pagination-sm" >
            <c:set var="end_var" value="${(postNumber/postsPerPage) + ((postNumber%postsPerPage) == 0 ? 0 : 1)}"/>
            <c:forEach var="i" begin="1" end="${end_var}" >
            <li>
            <a>
            <input type="submit" name="page" value="${i}" class="btn btn-link" >
            </a>
            </li>
            </c:forEach>
            </ul>
            <input type="hidden" name="type" value="pageForm" >
        </form>
    </div>
</body>
</html>