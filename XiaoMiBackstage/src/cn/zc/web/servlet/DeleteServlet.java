package cn.zc.web.servlet;

import cn.zc.domain.GoodsType;
import cn.zc.service.GoodsService;
import cn.zc.service.GoodsTypeService;
import cn.zc.service.UserService;
import cn.zc.service.impl.GoodsServiceImpl;
import cn.zc.service.impl.GoodsTypeServiceImpl;
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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取页面传递的id
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);
        // 删除用户
        UserService userService = new UserServiceImpl();
        userService.deleteById(id);
        // 删除商品
        GoodsService goodsService = new GoodsServiceImpl();
        goodsService.deleteById(id);
        //删除商品类型
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        goodsTypeService.deleteById(id);

    }
}

