<%--
  Created by IntelliJ IDEA.
  User: 16670
  Date: 2021/1/11
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 引入 ECharts 文件 -->
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery-1.8.3.js"></script>
    <title>Title</title>
</head>
<body>

<%--2.设定一个具有宽高的echarts容器--%>
<div id="main" style="width: 1000px;height: 400px">
    ​
</div>

<script type="text/javascript">
    $(function () {
        /*3.初始化echarts容器*/
        var eCharts = echarts.init(document.getElementById("main"));
        /*4.设定echarts属性*/
        eCharts.setOption({
            title: {
                text: '小米商城销量统计表'
            },
            tooltip: {},
            legend: {
                data: ['销量']
            },
            xAxis: {
                data: ["小米笔记本", "小米手机", "小米家电", "小米家具", "小米汽车", "小米周边"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        });
    });
</script>
</body>
</html>
