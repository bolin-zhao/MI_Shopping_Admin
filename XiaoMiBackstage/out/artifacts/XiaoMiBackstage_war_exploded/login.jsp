<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>小米商城系统-登录</title>
    <link rel="stylesheet" href="plugins/layui/css/layui.css"/><!-- layui 样式文件 -->
    <link rel="stylesheet" href="css/login-register.css"/>
</head>

<body>
<div class="login-wrap">
    <h1 class="wrap-title">用户登录</h1>
    <form class="layui-form layui-form-pane" action="userLogin?method=login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="required|userName" autocomplete="off"
                       placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
            <div class="layui-input-block">
                <input type="password" name="password" lay-verify="required|pass" placeholder="请输入密码" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <!-- <button class="layui-btn layui-btn-fluid layui-btn-radius" lay-submit lay-filter="J-submit">登录</button>-->
            <input type="submit" value="登录" class="layui-btn layui-btn-fluid layui-btn-radius"/>
        </div>
    </form>
</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script> <!-- layui js文件 -->
<script>
    layui.use('form', function () {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form;//引进form模块

        //自动以验证用户名密码方法
        form.verify({
            userName: function (value) {
                if (value.length < 2) {//如果用户名小于两位
                    return '用户名填写错误';
                }
            },
            pass: [/^[\S]{6,12}$/, '密码是6到12位']//提示密码填错
        });
        //监听提交按钮
        form.on('submit(J-submit)', function (data) {
            //location.href ='userLogin';//跳转
            return false; //不进行跳转需要加上
        });
    });
</script>
</body>

</html>