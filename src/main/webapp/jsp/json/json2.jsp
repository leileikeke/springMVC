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
    <button id="b1">发送一个Order对象到后台 , 并且以Ajax形式放</button>
    <button id="b2">发送一个List<Order>对象到后台 , 并且以Ajax形式放</button>


    <script>
        $(function () {
            $('#b1').click(function () {
                var obj={
                    id:'1',
                    name:'爷们',
                    price:'22.1'
                }
                $.ajax({
                    url:'${ctx}/json2/add',
                    type:'post',
                    contentType: "application/json",
                    data:JSON.stringify(obj),
                    succese:function (data) {
                        alert(data);
                    }
                })
            })

            $('#b2').click(function () {
                var obj1={
                    id:'1',
                    name:'爷们',
                    price:'22.1'
                }
                var obj2={
                    id:'2',
                    name:'爷们2',
                    price:'22.13'
                }
                var arr = new Array();
                arr.push(obj1);
                arr.push(obj2);
                $.ajax({
                    url:'${ctx}/json2/addList',
                    type:'post',
                    contentType: "application/json",
                    data:JSON.stringify(arr),
                    success:function (data) {
                        if (data.code == 2000){
                            alert("成功了");
                        }
                    }
                })
            })
        })
    </script>
</body>
</html>
