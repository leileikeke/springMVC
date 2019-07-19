<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/18
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>register先存dog</h1><br>
    <form action="${ctx}/dog/register" method="post">
        <input type="text" name="name">
        <br>
        <input type="text" name="password">
        <br>
        <input type="submit" value="提交">
    </form><br>
    <h1>redirect拿取dog</h1><br>
    <form action="${ctx}/dog/login" method="post">
        <input type="text" name="name">
        <br>
        <input type="text" name="password">
        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
