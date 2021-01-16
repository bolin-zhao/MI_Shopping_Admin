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
    <title>订单详情</title>

    <style type="text/css">
        #btnSearch{
            transform: translate(188px,-18px );
        }
        #searchText,#search{
            transform: translate(-2px,20px );
        }
    </style>
</head>
<body>
<script>
    layui.use(['layer', 'laydate', 'element', 'jquery', 'table', 'util'], function () {
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
            var layer = layui.layer;
            var $ = layui.jquery;
        });
        var active = {
            reload: function () {
                var sers = $("#search").val();//获得文本框的值
                if (sers === "") {
                    layer.msg("你要查找的订单搜索的时候不能为空");
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

    });
</script>

<div class="layui-form-item">
    <label class="layui-form-label" style="width: 88px" id="searchText">查找商品:</label>
    <div class="layui-input-inline">
        <input type="text" id="search" class="layui-input" width="150px"/>
        <a class="layui-btn" data-type="reload" id="btnSearch">搜索</a>

    </div>
</div>

<table class="layui-table" lay-data="{height:500,url:'orderDetailServlet?method=getOrderDetailView',page:true,id:'test'}"
       lay-filter="test">
    <thead>
    <th lay-data="{field:'id',align:'center',sort:true}">序号</th>
    <th lay-data="{field:'oid',align:'center',sort:true}">订单编号</th>
    <th lay-data="{field:'pid',align:'center',sort:true}">商品id</th>
    <th lay-data="{field:'num',align:'center',sort:true}">商品数量</th>
    <th lay-data="{field:'money',align:'center',sort:true}">总金额(¥)</th>
    <th lay-data="{title:'操作',align:'center',toolbar:'#barDemo'}">操作</th>
    </thead>
</table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-warm layui-btn-xs " lay-event="see"><i class="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #1E9FFF;"></i>你好啊</a>
</script>

</body>
</html>
