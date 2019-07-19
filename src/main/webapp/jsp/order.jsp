<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/12
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table align="1" border="1">
        <c:forEach items="${orders}" var="obj">
            <tr>
                <td>${obj.id}</td>
                <td>${obj.name}</td>
                <td>${obj.price}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
