<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">

    <head>
        <meta charset="utf-8">
        <title>Blog Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form action="/Login" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <button type="submit">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            <form action="/" method="post">
                <button type="submit">注册</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>


</html>

