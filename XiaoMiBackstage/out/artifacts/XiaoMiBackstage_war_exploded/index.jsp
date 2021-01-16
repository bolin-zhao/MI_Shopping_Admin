<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>MI后台管理系统</title>
    <link rel="stylesheet" href="./plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css" media="all" />
    <link rel="stylesheet" href="./build/css/app.css" media="all" />
    <link rel="stylesheet" href="./build/css/themes/default.css" media="all" id="skin" kit-skin />
</head>

<body class="kit-theme">
    <div class="layui-layout layui-layout-admin kit-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">小米商城后台管理</div>
            <div class="layui-logo kit-logo-mobile">MI</div>
            <ul class="layui-nav layui-layout-left kit-nav">
                <li class="layui-nav-item"><a href="javascript:;">新功能(一)</a></li>
                <li class="layui-nav-item"><a href="javascript:;">头条</a></li>
                <li class="layui-nav-item"><a href="javascript:;" id="pay"><i class="fa fa-gratipay" aria-hidden="true"></i> 丫丫</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">新功能(二)</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">邮件管理</a></dd>
                        <dd><a href="javascript:;">消息管理</a></dd>
                        <dd><a href="javascript:;">授权管理</a></dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right kit-nav">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe63f;</i> 换肤</a>
                    </a>
                    <dl class="layui-nav-child skin">
                        <dd><a href="javascript:;" data-skin="default" style="color:#393D49;"><i class="layui-icon">&#xe658;</i> 默认雅黑 </a></dd>
                        <dd><a href="javascript:;" data-skin="orange" style="color:#ff6700;"><i class="layui-icon">&#xe658;</i> 橘子橙 </a></dd>
                        <dd><a href="javascript:;" data-skin="green" style="color:#00a65a;"><i class="layui-icon">&#xe658;</i> 原谅绿 </a></dd>
                        <dd><a href="javascript:;" data-skin="pink" style="color:#FA6086;"><i class="layui-icon">&#xe658;</i> 少女粉 </a></dd>
                        <dd><a href="javascript:;" data-skin="blue.1" style="color:#00c0ef;"><i class="layui-icon">&#xe658;</i> 天空蓝 </a></dd>
                        <dd><a href="javascript:;" data-skin="red" style="color:#dd4b39;"><i class="layui-icon">&#xe658;</i> 枫叶红 </a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="https://i.loli.net/2021/01/02/FpMnYaX935IBVo1.jpg" class="layui-nav-img">${user.username}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" kit-target data-options="{url:'userbasic',icon:'&#xe658;',title:'基本资料',id:'966'}"><span>基本资料</span></a></dd>
                        <dd><a href="javascript:;">安全设置</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="userLogin?method=logOut"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black kit-side">
            <div class="layui-side-scroll">
                <div class="kit-side-fold"><i style="margin-top: 8px; font-size: 16px;" class="fa fa-navicon" aria-hidden="true"></i></div>
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i>&nbsp;<span>用户管理</span></a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" kit-target data-options="{url:'unactive.jsp',icon:'&#xe66f;',title:'用户管理',id:'1'}">
                                    <i class="layui-icon">&#xe66f;</i> &nbsp;<span>未激活用户管理</span></a>
                            </dd>

                            <dd>
                                <a href="javascript:;" data-url="active.jsp" data-icon="fa-user" data-title="激活用户管理" kit-target data-id='2'>
                                    <i class="fa fa-user" aria-hidden="true"></i>&nbsp;<span>激活用户管理</span></a>
                            </dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;"><i class="fa fa-" aria-hidden="true"></i><span>&nbsp;商品管理</span></a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" kit-target data-options="{url:'goodsList.jsp',icon:'&#xe66b;',title:'Navbar',id:'6'}"><i class="layui-icon">&#xe66b;</i>&nbsp;<span>商品列表</span></a></dd>
                            <dd><a href="javascript:;" kit-target data-options="{url:'goodsTypeList.jsp',icon:'&#xe653;',title:'TAB',id:'7'}"><i class="layui-icon">&#xe653;</i>&nbsp;<span>商品类型</span></a></dd>
                            <dd><a href="javascript:;" kit-target data-options="{url:'echarts.jsp',icon:'&#xe629;',title:'App',id:'8'}"><i class="layui-icon">&#xe629;</i>&nbsp;<span>商品数据可视化</span></a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item layui-nav-itemed">

                        <a class="" href="javascript:;"><i class="layui-icon layui-icon-cart" aria-hidden="true"></i>&nbsp;<span>订单管理</span></a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" kit-target data-options="{url:'orderList.jsp',icon:'&#xe63c;',title:'订单',id:'11'}">
                                    <i class="layui-icon">&#xe63c;</i>&nbsp;<span>&nbsp;订单列表</span></a>
                            </dd>

                            <dd>
                                <a href="javascript:;" kit-target data-options="{url:'orderDetailList.jsp',icon:'&#xe60b;',title:'订单详情',id:'12'}">
                                <i class="layui-icon">&#xe60b;</i>&nbsp;<span>&nbsp;订单详情</span></a>
                            </dd>
                        </dl>
                    </li>
                    <% %>
                </ul>
            </div>
        </div>


        <div class="layui-body" id="container">

            <!-- 内容主体区域 -->
<%--            <div style="padding: 15px;"><i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63e;</i> 请稍等...</div>--%>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            2021 &copy;
            <a href="https://www.bolin.github.io">分享技术</a> NO license yet
        </div>
    </div>
<%--    cnzz代码统计,记录网站访问数据--%>
<%--    <script type="text/javascript">--%>
<%--        var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");--%>
<%--        document.write(unescape("%3Cspan id='cnzz_stat_icon_1264021086'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264021086%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));--%>
<%--    </script>--%>
    <script src="./plugins/layui/layui.js"></script>

    <script>
        var message;
        layui.config({
            base: 'build/js/',
            version: '1.0.1'
        }).use(['app', 'message'], function() {
            var app = layui.app,
                $ = layui.jquery,
                layer = layui.layer;
            //将message设置为全局以便页面调用
            message = layui.message;
            //1. 主入口
            app.set({
                type: 'iframe'
            }).init();

            // 2. 捐助我模块
            $('#pay').on('click', function() {
                layer.open({
                    title: false,
                    type: 1,
                    content: '<img src="/src/images/yaya.jpg" />',
                    area: ['500px', '500px'],
                    shadeClose: true
                });
            });

            // 3.皮肤界面
            $('dl.skin > dd').on('click', function() {
                var $that = $(this);
                var skin = $that.children('a').data('skin');
                switchSkin(skin);
            });
            var setSkin = function(value) {
                    layui.data('kit_skin', {
                        key: 'skin',
                        value: value
                    });
                },
                getSkinName = function() {
                    return layui.data('kit_skin').skin;
                },
                switchSkin = function(value) {
                    var _target = $('link[kit-skin]')[0];
                    _target.href = _target.href.substring(0, _target.href.lastIndexOf('/') + 1) + value + _target.href.substring(_target.href.lastIndexOf('.'));
                    setSkin(value);
                },
                initSkin = function() {
                    var skin = getSkinName();
                    switchSkin(skin === undefined ? 'default' : skin);
                }();
        });
    </script>
</body>

</html>