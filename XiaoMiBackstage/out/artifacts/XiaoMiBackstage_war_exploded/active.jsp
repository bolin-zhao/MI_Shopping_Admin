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
                    closeBtn: 1,
                    content: "details?id=" + data.id,
                    area: ['450px', '500px'],
                    shade: 0.3,
                    maxmin: true
                });
            } else if (layEvent == "unActivate") {
                var URL = encodeURI(JSON.stringify(data));
                $.ajax({
                    type: "get",
                    url: "update?isFlag=0&&str=" + URL,
                    dataType: "text",
                    success: function (data) {//成功回调函数
                        layer.msg("该用户已冻结!");
                        location.reload();
                    }
                });
            } else if (layEvent == "delete") {
                layer.confirm('真的删除行么?', function (index) {
                    obj.del(obj); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                   // console.log(obj);
                   // console.log(obj.data.id);
                    var id = obj.data.id;
                    $.ajax({
                        type:"get",
                        url:'delete?id='+id,
                        success:function (data) {
                            layer.msg("删除成功");
                        }
                    })
                });
                //location.reload();
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
        <a href="javascript:location.reload();" class="layui-btn layui-btn-normal " style="transform: translate(47px)">刷新</a>
    </div>
</div>

<table class="layui-table" lay-data="{height:500,url:'userLogin?method=findAll&flag=1',page:true,id:'test'}"
       lay-filter="test">
    <thead>
    <th lay-data="{field:'id',sort:true,width:120}">用户编号</th>
    <th lay-data="{field:'username',sort:true,width:120}">用户名称</th>
    <th lay-data="{field:'password',sort:true,width:120}">用户密码</th>
    <th lay-data="{field:'email',sort:true,width:180}">邮箱</th>
    <th lay-data="{field:'gender',sort:true,width:90}">性别</th>
    <th lay-data="{title:'操作',align:'center',width:300,toolbar:'#barDemo'}">操作</th>
    </thead>
</table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="unActivate">冻结</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs layui-btn-disabled" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>
</body>
</html>