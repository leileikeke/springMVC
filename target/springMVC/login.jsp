<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/18
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/user/login" method="post">
        <input type="text" name="name">
        <br>
        <input type="password" name="password">
        <br>
        <input type="date" name="birthday">
        <input type="submit" value="提交">
    </form>
</body>
</html>
