<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/19
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <table class="layui-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>电话</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${masters}" var="obj">
            <tr>
                <td>${obj.id}</td>
                <td>${obj.name}</td>
                <td>${obj.tel}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>

