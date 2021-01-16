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
                url: "goodsDetails?str=" + URL,//data.field从数据中拿到字段的值
                dataType: "text",
                success: function (data) {
                    if (data == 1) {
                        layer.alert("成功");
                        location.reload();
                        parent.layer.close(index);
                    }
                }
            });
            return false;
        });
    });
</script>

<form class="layui-form layui-form-pane" action="goodsDetails" method="post" id="table">
    <div class="layui-form-item">
        <label class="layui-form-label">商品编号</label>
        <div class="layui-input-block">
            <input type="text" name="id" class="layui-input" readonly="readonly"  value="${goods.id}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input" value="${goods.name}"/>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">上传日期</label>
        <div class="layui-input-block">
            <input type="text" name="pubdate" class="layui-input" value="${goods.pubdate}"/>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">图片名</label>
        <div class="layui-input-block">
            <input type="text" name="picture" class="layui-input" value="${goods.picture}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input type="text" name="price" class="layui-input" value="${goods.price}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">热度</label>
        <div class="layui-input-block">
            <input type="text" name="star" class="layui-input" value="${goods.star}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">简介</label>
        <div class="layui-input-block">
            <input type="text" name="intro" class="layui-input" value="${goods.intro}"/>
<%--            <textarea name="intro"  class="layui-textarea" readonly="readonly"value="${goods.intro}"></textarea>--%>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品类型</label>
        <div class="layui-input-block">
            <input type="text" name="typeid" class="layui-input" value="${goods.typeid}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn ${flag}==0?'layui-btn-disabled':''" value="提交" lay-submit lay-filter="btnAdd"  >提交</button>
        </div>
    </div>

</form>

</body>
</html>