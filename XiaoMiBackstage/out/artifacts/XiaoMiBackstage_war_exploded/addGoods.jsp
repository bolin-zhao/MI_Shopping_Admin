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
                url: "addGoods?str=" + URL,//data.field从数据中拿到字段的值
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

        // upload.render({
        //     elem: '#btnimg'//表示你当前点什么开始弹出上传框
        //     , url: 'fileupload' // 上传接口,需要连接服务器(写一个servlet接口?)??????
        //     , auto: false
        //     , bindAction: '#btnupload'
        //     , accept: 'file'
        //     , done: function (res) {//上传文件成功后回调函数
        //         //alert(res.data);
        //         $("[name=picture]").val(res.data);
        //     }
        // });

    });
</script>
<form class="layui-form layui-form-pane" action="#" method="post">

    <div class="layui-form-item">
        <label class="layui-form-label">商品名</label>
        <div class="layui-input-block">
            <input type="text" name="name" class="layui-input"/>
        </div>
    </div>

<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">上传图片</label>--%>
<%--        <div class="layui-upload layui-input-block">--%>
<%--            <input type="hidden" name="picture" value=""/>--%>
<%--            <button type="button" class="layui-btn" id="btnimg"><i class="layui-icon">&#xe67c;</i>选择文件</button>--%>
<%--            <button type="button" class="layui-btn layui-btn-warm" id="btnupload">开始上传</button>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">图片</label>
        <div class="layui-input-block">
            <input type="text" name="picture" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">价格(¥)</label>
        <div class="layui-input-block">
            <input type="text" name="price" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">热度</label>
        <div class="layui-input-block">
            <input type="text" name="star" class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">简介</label>
        <div class="layui-input-block">
            <input type="text" name="intro" class="layui-input"/>
        </div>
    </div>

<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">商品类型</label>--%>
<%--        <div class="layui-input-block">--%>
<%--            <select name="typeid">--%>
<%--                <c:forEach items="${list}" var="l">--%>
<%--                    <option value="${l.typeid}">${l.typeid}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">商品类型</label>
        <div class="layui-input-block">
            <input type="text" name="typeid" class="layui-input"/>
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