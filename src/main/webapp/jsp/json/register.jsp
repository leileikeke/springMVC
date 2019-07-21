<%--
  Created by IntelliJ IDEA.
  User: leike
  Date: 2019/7/21
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/static/plugins/jQuery/jquery-1.12.4.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body>
<form action="${ctx}/user/register" class="layui-form layui-form-pane">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-inline">
            <input type="text" name="name" required="" lay-verify="required" placeholder="请输入用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"><span id="msg"></span></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密  码:</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required="" lay-verify="required" placeholder="请输入密码"
                   autocomplete="off" class="layui-input">
        </div>
<%--        <div class="layui-form-mid layui-word-aux"><span id="msg"></span></div>--%>
    </div>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">选择框</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <select name="city" lay-verify="required">--%>
<%--                <option value=""></option>--%>
<%--                <option value="0">北京</option>--%>
<%--                <option value="1">上海</option>--%>
<%--                <option value="2">广州</option>--%>
<%--                <option value="3">深圳</option>--%>
<%--                <option value="4">杭州</option>--%>
<%--            </select>--%>
<%--            <div class="layui-unselect layui-form-select">--%>
<%--                <div class="layui-select-title"><input type="text" placeholder="请选择" value="" readonly=""--%>
<%--                                                       class="layui-input layui-unselect"><i class="layui-edge"></i>--%>
<%--                </div>--%>
<%--                <dl class="layui-anim layui-anim-upbit" style="">--%>
<%--                    <dd lay-value="" class="layui-select-tips layui-this">请选择</dd>--%>
<%--                    <dd lay-value="0" class="">北京</dd>--%>
<%--                    <dd lay-value="1" class="">上海</dd>--%>
<%--                    <dd lay-value="2" class="">广州</dd>--%>
<%--                    <dd lay-value="3" class="">深圳</dd>--%>
<%--                    <dd lay-value="4" class="">杭州</dd>--%>
<%--                </dl>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="layui-form-item" pane="">--%>
<%--        <label class="layui-form-label">开关</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="checkbox" name="switch" lay-skin="switch">--%>
<%--            <div class="layui-unselect layui-form-switch" lay-skin="_switch"><em></em><i></i></div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="layui-form-item" pane="">--%>
<%--        <label class="layui-form-label">单选框</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <input type="radio" name="sex" value="男" title="男">--%>
<%--            <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>--%>
<%--                <div>男</div>--%>
<%--            </div>--%>
<%--            <input type="radio" name="sex" value="女" title="女" checked="">--%>
<%--            <div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i>--%>
<%--                <div>女</div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="layui-form-item layui-form-text">--%>
<%--        <label class="layui-form-label">文本域</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <textarea placeholder="请输入内容" class="layui-textarea"></textarea>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="formDemoPane">立即提交</button>
    </div>
</form>

<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'jquery', 'layer'], function () {
        var element = layui.element;
        var jquery = layui.jquery;
        var layer = layui.layer;
    });
    $(function () {
        $('input[name=name]').blur(function () {
            //获取name
            var name = $('input[name=name]').val();
            $.ajax({
                url: "${ctx}/user/checkname",
                type: "post",
                contentType: "application/JSON",
                data: JSON.stringify({
                    'name': name
                }),
                success: function (data) {
                    if (data.code == 2000) {
                        $("#msg").html("可用")
                        layer.msg('用户名可用', {icon: 1});
                    } else if (data.code == 300) {
                        $("#msg").html("请输入用户名")
                        layer.msg('请输入用户名', {icon: 6});
                    }else {
                        $("#msg").html("账号已被注册")
                        layer.msg('用户名已被注册', {icon: 2});
                    }
                }
            })
        })

    })
</script>

</body>
</html>
