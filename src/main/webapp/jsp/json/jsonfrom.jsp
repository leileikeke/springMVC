<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/20
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json</title>
    <script src="${ctx}/static/plugins/jQuery/jquery-1.12.4.min.js"></script>
</head>
<body>
<button id="b1">请求得到一个User</button>
<button id="b2">请求得到一个Map</button>
<button id="b3">请求得到一个List</button>
<button id="b4">请求得到一个数组[]</button>

<%--    <form action="/json" method="post">--%>
<%--        用户名:--%>
<%--        <input type="text" name="name"><br>--%>
<%--        密码:--%>
<%--        <input type="password" name="password"><br>--%>
<%--        创建日期:--%>
<%--        <input type="date" name="birthday"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<script>
    $(function () {
        $('#b1').click(function () {
            $.ajax({
                url: '${ctx}/json/m1',
                type: 'post',
                success: function (data) {
                    alert(data.name);
                    alert(data.id);
                    alert(data.price);
                }
            })
        })
        $('#b2').click(function () {
            $.ajax({
                url: '${ctx}/json/m2',
                type: 'post',
                success: function (data) {
                    //有点小差别懒得改
                    alert(data.name);
                    alert(data.id);
                    alert(data.price);
                }
            })
        })
        $('#b3').click(function () {
            $.ajax({
                url: '${ctx}/json/m3',
                type: 'post',
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        alert(data[i].name);
                    }
                }
            })
        })
        $('#b4').click(function () {
            $.ajax({
                url: '${ctx}/json/m4',
                type: 'post',
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        alert(data[i].name);
                    }
                }
            })
        })
    })
</script>
</body>
</html>
