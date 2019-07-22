<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/22
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/use/login" method="post">
        <input type="text" name="name">
        <br>
        <input type="password" name="pwd">
        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
