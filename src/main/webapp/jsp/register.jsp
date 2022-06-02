<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/7
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="../sm/register" method="post">
        用户名：<input type="text" name="user.username" /><br>
        密码：<input type="password" name="user.password" /><br>
        年龄1：<input type="text" name="user.age" /><br>
        <input type="submit" value="确定" />
    </form>
</body>
</html>
