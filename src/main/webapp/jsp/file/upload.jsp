<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/21
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
        文件:<input type="file" name="file">
        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
