package cn.zc.web.servlet;

import cn.zc.domain.Goods;
import cn.zc.domain.User;
import cn.zc.service.GoodsService;
import cn.zc.service.UserService;
import cn.zc.service.impl.GoodsServiceImpl;
import cn.zc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create By Bolin on ${DATA}
 */
@WebServlet("/details")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取页面传递的id值
        String id = request.getParameter("id");
        UserService userService = new UserServiceImpl();
        User user = userService.findById(id);
//        GoodsService goodsService = new GoodsServiceImpl();
//        Goods goods = goodsService.findById(id);
        // System.out.println(id);
        request.setAttribute("user", user);
        // System.out.println(user);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

