package cn.zc.web.servlet;


import cn.dsna.util.images.ValidateCode;
import cn.zc.domain.Address;
import cn.zc.domain.User;
import cn.zc.service.AddressService;
import cn.zc.service.UserService;
import cn.zc.service.impl.AddressServiceImpl;
import cn.zc.service.impl.UserServiceImpl;
import cn.zc.utils.RandomUtils;
import cn.zc.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/userLogin")
public class Userservlet extends BaseServlet{

    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        1.接收页面输入的用户名
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)){
            return "/login.jsp";
        }
        UserServiceImpl userService = new UserServiceImpl();
//        2.把页面接收的用户名传值过去
        User user = userService.findByUsername(username);
        System.out.println("user对象是："+user);
//        3.判断从数据库中接收到的user对象是否为空？ 如果不为空 则返回1 否则返回0
        if (user !=null){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("0");
        }
        return null;
    }

//    登陆功能
    public String login(HttpServletRequest request,HttpServletResponse response){
//         1.获取页面输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//          2.把页面输入的值作为参数传递给service层 然后传给dao层
//        获得一个user对象的返回值
        UserService userService = new UserServiceImpl();
        User user = userService.login(username,password);

//        数据回显 把接收到的user对象存储在session中 键名为 user
        request.getSession().setAttribute("user",user);
//        3.判断是否user是否有值
        if (user!=null&&user.getRole()==0){
            return "index.jsp";
        }else {
            return "login.jsp";
        }
    }

//      注销功能
    public String logOut(HttpServletRequest request,HttpServletResponse response){
//        删除session中的值
        request.getSession().removeAttribute("user");
//        直接使session失效  ，两者都可以，后者更绝对
        request.getSession().invalidate();
        return "index.jsp";
    }

//    查找所有未激活/激活的用户

    public String findAll(HttpServletRequest request,HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = (User) request.getSession().getAttribute("user");
        if (user==null&&user.getRole()==1){
            return "/login.jsp";
        }
        UserService userService = new UserServiceImpl();
        List<User> lists =null;
        // 获取sers对象
        String sers = request.getParameter("sers");

        // 获取layUI分页功能页面传递的参数limit/page
        String limit0 = request.getParameter("limit");
        String page0 = request.getParameter("page");
        int limit = Integer.parseInt(limit0);
        int page = Integer.parseInt(page0);

        // 把数据转为json格式,去前端渲染
        JSONObject jsonObject = new JSONObject();
        String flag1 = request.getParameter("flag");
        int flag = Integer.parseInt(flag1);

        // 获取总数据条数
        int result = userService.getCount(flag);
        if (sers != null){
            // 如果不为空,就模糊查询未激活的用户
            lists= userService.findallByNameOrId(sers,flag);
            jsonObject.put("count",0);
        }else {
            //如果为空,就查询所有未激活的用户
            lists = userService.findallByFlag(flag,limit,page);
            // System.out.println(lists);
            jsonObject.put("count",result);
        }

        jsonObject.put("code",0);
        jsonObject.put("msg","");

        Object data = JSON.toJSON(lists);
        jsonObject.put("data",data);
        response.getWriter().write(jsonObject.toString());
        return null;
    }

}
