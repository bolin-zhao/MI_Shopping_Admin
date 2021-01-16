<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>小米商城管理员动态表格数据处理</title>
    <link href="plugins/layui/css/layui.css" rel="stylesheet"/><!-- 引入layui的样式 -->
    <script charset="utf-8" src="plugins/layui/layui.js"></script><!-- 引入layui的js -->
</head>
<body>
<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;

        table.on('tool(test)', function (obj) {
            var value = obj.value;
            var data = obj.data;
            var field = obj.field;
            var layEvent = obj.event;
            if (layEvent == "detail") {
                //弹出层
                layer.open({
                    type: 2,
                    title: "用户信息",
                    content: "details?id=" + data.id,
                    area: ['450px', '500px'],
                    shade: 0.3,
                    maxmin: true
                });
            } else if (layEvent == "active") {
                var URL = encodeURI(JSON.stringify(data));
                $.ajax({
                    type: "get",
                    url: "update?isFlag=1&&str=" + URL,
                    dataType: "text",
                    success: function (data) {//成功回调函数
                        layer.msg("激活成功");
                        location.reload();
                    }
                });
            } else if (layEvent == "add") {
                layer.open({
                    type: 2,
                    title: "添加管理员",
                    content: "add.jsp",
                    area: ['450px', '500px'],
                    shade: 0.3,
                    maxmin: true,
                    end: function () {
                        location.reload();
                    }
                });
            } else if (layEvent == "start") {
                $.ajax({
                    type: "get",
                    url: "updatestate?id=" + data.id + "&&state=1",
                    dataType: "text",
                    success: function (data) {//成功回调函数
                        //obj.del();
                        location.reload();
                    }
                });
            } else if (layEvent == "disable") {
                $.ajax({
                    type: "get",
                    url: "updatestate?id=" + data.id + "&&state=0",
                    dataType: "text",
                    success: function (data) {//成功回调函数
                        //obj.del();
                        location.reload();
                    }
                });
            }
        });

        var active = {
            reload: function () {
                var sers = $("#search").val();//获得文本框的值
                if (sers === "") {
                    layer.msg("你要查找的用户搜索的时候不能为空");
                } else {
                    table.reload("test", {
                        where: {
                            sers: sers//把获得的文本框的值传入给sers的参数（赋值）
                        },
                        page: {
                            curr: 1
                        }
                    });
                }
            }
        }
        $("#btnSearch").click(function () {//layui表格要重新加载，所以说我们要监听按钮的事件
            var type = $(this).data("type");
            active[type] ? active[type].call(this) : "";
        });

    });
</script>

<div class="layui-form-item">
    <label class="layui-form-label">查找用户:</label>
    <div class="layui-input-inline">
        <input type="text" id="search" class="layui-input" width="150px" />
        <a class="layui-btn" data-type="reload" id="btnSearch">搜索</a>
        <a href="javascript:location.reload();" class="layui-btn layui-btn-normal" style="transform: translate(47px)">刷新</a>
    </div>
</div>

<table class="layui-table" lay-data="{height:500,url:'userLogin?method=findAll&flag=0',page:true,id:'test'}"
       lay-filter="test">
    <thead>
    <th lay-data="{field:'id',sort:true,align:'center',width:120}">用户编号</th>
    <th lay-data="{field:'username',sort:true,align:'center',width:120}">用户名称</th>
    <th lay-data="{field:'password',sort:true,align:'center',width:120}">用户密码</th>
    <th lay-data="{field:'email',sort:true,align:'center',width:180}">邮箱</th>
    <th lay-data="{field:'gender',sort:true,align:'center',width:90}">性别</th>
    <th lay-data="{title:'操作',align:'center',width:300,toolbar:'#barDemo'}">操作</th>
    </thead>
</table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs " lay-event="active">激活</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="add">添加</a>
</script>
</body>
</html>