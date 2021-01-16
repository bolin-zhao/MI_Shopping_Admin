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

<form class="layui-form layui-form-pane" action="details" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户编号</label>
        <div class="layui-input-block">
            <input type="text" name="id" class="layui-input" readonly="readonly" value="${user.id}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户名称</label>
        <div class="layui-input-block">
            <input type="text" name="userName" class="layui-input" readonly="readonly" value="${user.username}"/>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">用户密码</label>
        <div class="layui-input-block">
            <input type="text" name="pwd" class="layui-input" readonly="readonly" value="${user.password}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="trueName" class="layui-input" readonly="readonly" value="${user.email}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" name="sex" class="layui-input" readonly="readonly" value="${user.gender}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">管理员</label>
        <div class="layui-input-block">
            <input type="text" name="role" class="layui-input" readonly="readonly" value="${user.role eq 0?'是':'否'}"/>
        </div>
    </div>

</form>

</body>
</html>