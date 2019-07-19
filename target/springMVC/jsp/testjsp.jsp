<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/12
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    <c:forEach items="${lists}" var="lists">
        <tr>
            <td>${lists.id}</td>
            <td>${lists.name}</td>
            <td>${lists.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
