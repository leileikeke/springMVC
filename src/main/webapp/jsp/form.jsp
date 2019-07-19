<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/12
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    request
    <form action="${ctx}/web/m2" method="post">
        <input type="submit" value="请求m1 m2提交">
    </form>
    post
    <form action="${ctx}/web/m3" method="post">
        <input type="submit" value="post请求m3提交">
    </form>
    get
    <form action="${ctx}/web/m3" method="get">
        <input type="submit" value="post请求m3">
    </form>
    delete
    <form action="${ctx}/web/m4" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="delete请求m4提交">
    </form>
</body>
</html>
