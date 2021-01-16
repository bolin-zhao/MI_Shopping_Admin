<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="plugins/layui/css/layui.css" rel="stylesheet"/><!-- 引入layui的样式 -->
    <script charset="utf-8" src="plugins/layui/layui.js"></script>
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
                url: "goodsTypeDetails?str=" + URL,//data.field从数据中拿到字段的值
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

<form class="layui-form layui-form-pane" action="goodsTypeDetails" method="post" id="table">
    <div class="layui-form-item">
        <label class="layui-form-label">商品类型编号</label>
        <div class="layui-input-block">
            <input type="text" name="id" class="layui-input" readonly="readonly"  value="${goodsType.id}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品类型名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input" value="${goodsType.name}"/>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">商品等级</label>
        <div class="layui-input-block">
            <input type="text" name="level" class="layui-input" value="${goodsType.level}"/>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">所属类型</label>
        <div class="layui-input-block">
            <input type="text" name="parent" class="layui-input" value="${goodsType.parent}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" value="修改" lay-submit lay-filter="btnAdd" >修改</button>
        </div>
    </div>

</form>

</body>
</html>