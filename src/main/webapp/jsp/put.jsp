<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/17
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user_put</title>
</head>
<body>
    <form action="${ctx}/user/put2" method="post">
        <input type="hidden" name="_method" value="put">
        <input type="text" name="name">
        <br>
        <input type="password" name="password">
        <br>
        <input type="date" name="birthday">
        <input type="submit" value="提交">
    </form>
</body>
</html>
