<%--
  Created by IntelliJ IDEA.
  User: 16670
  Date: 2021/1/5
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="js/jquery-1.8.3.js"></script>
    <link href="plugins/layui/css/layui.css" rel="stylesheet"/><!-- 引入layui的样式 -->
    <script charset="utf-8" src="plugins/layui/layui.js"></script><!-- 引入layui的js -->
    <title>商品列表</title>
</head>
<body>
<script>
    layui.use(['layer', 'laydate', 'element', 'jquery', 'table','util' ], function () {
        var laydate = layui.laydate;
        var table = layui.table;
        var element = layui.element;
        var layer = layui.layer;
        var $ = layui.jquery;
        var util = layui.util;

        table.on('tool(test)', function (obj) {
            var value = obj.value;
            var data = obj.data;
            var field = obj.field;
            var layEvent = obj.event;
            if (layEvent == "goodsDetail") {
                //弹出层
                layer.open({
                    type: 2,
                    title: "查看商品",
                    closeBtn: 1,
                    content: "goodsDetails?flag=0&id=" + data.id,
                    area: ['500px', '600px'],
                    shade: 0.3,
                    maxmin: true
                });

            } else if (layEvent == "goodsDelete") {
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
                            location.reload();
                        }
                    })
                });
            }else if (layEvent == "edit"){
                //弹出层
                layer.open({
                    type: 2,
                    title: "编辑",
                    closeBtn: 1,
                    content: "goodsDetails?&id=" + data.id,
                    area: ['450px', '500px'],
                    shade: 0.3,
                    maxmin: true
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
            console.log("点击了搜索按钮");
            var type = $(this).data("type");
            active[type] ? active[type].call(this) : "";
        });

        $("#btnAdd").click(function () {//layui表格要重新加载，所以说我们要监听按钮的事件
            console.log("点击了添加按钮");
            layer.open({
                type: 2,
                title: "添加商品",
                content: "addGoods.jsp",
                area: ['450px', '500px'],
                shade: 0.3,
                maxmin: true,
                end: function () {
                    location.reload();
                }
            })
        });
    });
</script>

<%--    上架时间--%>
<script type="text/html" id="pubdate">
    {{#if (d.pubdate !=0){ }}
    <div>
    {{layui.util.toDateString(d.pubdate)}}
    </div>
    {# }else{ }}
    <div>
    {{0}}
    </div>
    {{# }}}
</script>

<div class="layui-form-item">
    <label class="layui-form-label">查找商品:</label>
    <div class="layui-input-inline">
        <input type="text" id="search" class="layui-input" width="150px" />
        <a class="layui-btn" data-type="reload" id="btnSearch">搜索</a>
        <a class="layui-btn layui-btn-warm" data-type="reload" id="btnAdd" style="transform: translate(20px)">添加商品</a>
    </div>
</div>

<table class="layui-table" lay-data="{height:500,url:'GoodsServlet?method=findAllGoods',page:true,id:'test'}"
       lay-filter="test">
    <thead>
    <th lay-data="{field:'id',align:'center',sort:true}">商品编号</th>
    <th lay-data="{field:'name',align:'center',sort:true}">商品名称</th>
<%--    <th lay-data="{field:'pubdate',align:'center',sort:true,templet:'<div>{{ layui.util.toDateString(d.pubdate)}}</div>'}">上架日期</th>--%>
    <th lay-data="{field:'pubdate',align:'center',sort:true,templet:'#pubdate'}">上架日期</th>
    <th lay-data="{field:'price',align:'center',sort:true}">价格(¥)</th>
    <th lay-data="{field:'star',align:'center',sort:true}">热度</th>
    <th lay-data="{field:'typeid',align:'center',sort:true}">类型</th>
    <th lay-data="{title:'操作',align:'center',toolbar:'#barDemo'}">操作</th>
    </thead>
</table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="goodsDetail">查看</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs layui-btn-warm" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="goodsDelete">删除</a>
</script>
</body>
</html>
