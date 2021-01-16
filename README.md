# MI_Shopping_Admin
### 仿小米商城后台管理系统

- 项目介绍

上个项目完成了基于JavaWeb的小米商城前台展示, 这个项目为了实现相关后台管理功能,同样适用 了JavaWeb开发,完成了后台管理员的登录功能,商品列表/详情/订单的增删改查,账户激活/冻结,等功能。

- 技术栈

1. 开发工具: IDEA 

2. 数据库: MySQL + sqlyog(sql建表工具)

3. 相关技术: JavaWeb + JDBC(工具类) + Druid(数据库连接池) + Tomcat8.5.32 服务器  + jQuery + echarts图表 + layui框架 + ajax + log4j(日志管理) + MVC三层架构

- 项目截图

1. 管理员登录界面

![image-20210116224411349](C:\Users\16670\Desktop\mi\MI_Shopping_Admin\image-20210116224411349.png)

2. layui主页面

![image-20210116224613878](C:\Users\16670\Desktop\mi\MI_Shopping_Admin\image-20210116224613878.png)

3. 用户列表页

![image-20210116224743850](C:\Users\16670\Desktop\mi\MI_Shopping_Admin\image-20210116224743850.png)

4. 商品列表页

![image-20210116224839446](C:\Users\16670\Desktop\mi\MI_Shopping_Admin\image-20210116224839446.png)

5. 订单列表页

![image-20210116224924402](C:\Users\16670\Desktop\mi\MI_Shopping_Admin\image-20210116224924402.png)

6. 商品数据图表echarts

![image-20210116225031867](C:\Users\16670\Desktop\mi\MI_Shopping_Admin\image-20210116225031867.png)



- 总结:

> 通过这个项目的学习, 我对JavaWeb有了更深的了解, 对MVC 三层架构开发编程有了一个系统的认识, 从此有了 model层 ==> view视图层 ==> controller控制层的概念. 
>
> 对实体类domain, 控制器servlet, 业务层service, 数据库操作dao层, utils工具类, filter过滤器, 有了一个印象深刻的体验
>
> 同时学到了Tomcat服务器的部署, 对druid数据库连接池, log4j日志管理插件都有了初步的应用
>
> 但是, 频繁的数据库操作, 代码的大量重复,让我认识到这不是真正的企业级开发, JavaWeb技术臃肿的架构已经不是一个合适的方案, druid的应用,让我减少了对 JDBC 传统操作数据库的繁琐, 但是, 多次的连接释放资源, 让开发流程变成了搬砖, 只有很少的精力放在了代码逻辑的编写上,
>
> 我在寻求更好,更合适的方案, 以去除代码冗余度, 减少搬砖的事件, 更多的精力专注在业务层.
>
> 这大概就是我接下来学习Spring MVC 的理由吧 ! (哈哈)