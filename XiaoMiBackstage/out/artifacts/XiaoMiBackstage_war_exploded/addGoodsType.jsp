<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="plugins/layui/css/layui.css" rel="stylesheet"/><!-- 引入layui的样式 -->
    <script charset="utf-8" src="plugins/layui/layui.js"></script>
    <script src="js/jquery-1.8.3.js"></script>
</head>
<body>
<script>
    layui.use(['form', 'upload'], function () {
        var form = layui.form;
        var $ = layui.jquery;
        var upload = layui.upload;
        var layer = layui.layer;
        var index = parent.layer.getFrameIndex(window.name);

        form.on('submit(btnAdd)', function (data) {
            alert(JSON.stringify(data.field));
            var URL = encodeURI(JSON.stringify(data.field));
            $.ajax({
                type: "post",
                url: "addGoodsType?str=" + URL,//data.field从数据中拿到字段的值
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
<form class="layui-form layui-form-pane" action="#" method="post">

    <div class="layui-form-item">
        <label class="layui-form-label" style="width: 109px;padding: 5px 5px;">商品类型编号</label>
        <div class="layui-input-block" style="width: 330px">
            <input type="text" name="id" readonly  class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品类型</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">等级</label>
        <div class="layui-input-block">
            <input type="text" name="level" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">所属类型</label>
        <div class="layui-input-block">
            <input type="text" name="parent" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" value="添加" lay-submit lay-filter="btnAdd">添加</button>
        </div>
    </div>

</form>
</body>
</html>