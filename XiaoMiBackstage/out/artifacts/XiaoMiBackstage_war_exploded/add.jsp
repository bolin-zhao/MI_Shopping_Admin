<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="plugins/layui/css/layui.css" rel="stylesheet"/><!-- 引入layui的样式 -->
    <script charset="utf-8" src="plugins/layui/layui.js"></script>
    <script charset="utf-8" src="jquery-1.8.3.js"></script>
</head>
<body>

<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer;
        var index = parent.layer.getFrameIndex(window.name);


        form.on('submit(btnAdd)', function (data) {
        	var URL = encodeURI(JSON.stringify(data.field));
            $.ajax({
                type: "post",
                url: "add?str=" + URL,//data.field从数据中拿到字段的值
                dataType: "text",
                success: function (data) {
                    if (data == 1) {
                        layer.alert("成功");
                        parent.layer.close(index);
                    }
                }
            });
            return false;
        });
    });
</script>
<form class="layui-form layui-form-pane" action="add" method="post">

    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" class="layui-input"/>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">用户密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" name="gender" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" value="提交" lay-submit lay-filter="btnAdd">提交</button>
        </div>
    </div>

</form>
</body>
</html>