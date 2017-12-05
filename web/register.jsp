<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4 0004
  Time: 下午 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/md5.js" type="text/javascript"></script>
<head>
    <title>注册</title>

</head>
<body>

<form action="/Register" method="post" onsubmit="encry()">
   <input type="hidden" id ="password"  name ="password">
    帐号: <input type="text"   name = "account" value="${param.account}"/><br>
    密码: <input type="password" id = "passwordMd5" value = "" /><br>
   用户名:<input type="text" name = "name" value="${param.name}"/><br>
    <input type="submit" value ="注册"/>
</form>

<script>
    function encry (){
        var password = document.getElementById("passwordMd5");
        var passwordMD5 = document.getElementById("password");
        passwordMD5.value = hex_md5(password);
        return true;
    }

</script>
</body>

</html>
