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
    <title>商品类型列表</title>

    <style type="text/css">
        #btnSearch{
            transform: translate(189px,13px );
        }
        #searchText,#search{
            transform: translate(10px,50px );
        }
    </style>
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

            if (layEvent == "GoodsTypeDelete") {
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
            }else if (layEvent == "goodsTypeEdit"){
                //弹出层
                layer.open({
                    type: 2,
                    title: "编辑",
                    closeBtn: 1,
                    content: "goodsTypeDetails?id=" + data.id,
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
                title: "添加商品类型",
                content: "addGoodsType.jsp",
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
<div class="layui-form-item">
    <label class="layui-form-label" style="width: 88px" id="searchText">查找商品类型:</label>
    <div class="layui-input-inline" id="searchInput">
        <input type="text" id="search" class="layui-input" width="150px" />
        <a class="layui-btn" data-type="reload" id="btnSearch">搜索</a>
        <a class="layui-btn layui-btn-warm" data-type="reload" id="btnAdd" style="transform: translate(1033px,-20px)">添加商品类型</a>
    </div>
</div>

<table class="layui-table" lay-data="{height:500,url:'GoodsTypeServlet?method=findAllGoodsType',page:true,id:'test'}"
       lay-filter="test">
    <thead>
    <th lay-data="{field:'id',align:'center',sort:true}">商品类型编号</th>
    <th lay-data="{field:'name',align:'center',sort:true}">商品类型名称</th>
    <th lay-data="{field:'level',align:'center',sort:true}">商品等级</th>
    <th lay-data="{field:'parent',align:'center',sort:true}">所属类型</th>
    <th lay-data="{title:'操作',align:'center',toolbar:'#barDemo'}">操作</th>
    </thead>
</table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-warm layui-btn-xs " lay-event="goodsTypeEdit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="GoodsTypeDelete" >删除</a>
</script>
</body>
</html>
