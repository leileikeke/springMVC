<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/20
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/static/plugins/jQuery/jquery-1.12.4.min.js"></script>
</head>
<body>
    <button id="b">发送一个Order对象到后台 , 并且以Ajax形式放</button>


    <script>
        $(function () {

            $('#b').click(function () {

                var obj={
                    id:'1',
                    name:'爷们',
                    price:'22.1'
                }

                $.ajax({
                    url:'${ctx}/json2/add',
                    type:'post',
                    contentType: "application/json",
                    data:JSON.stringify({id:"1",name:'叶问',price:'233.13'}),
                    succese:function (data) {

                    }
                })
            })

        })
    </script>
</body>
</html>
