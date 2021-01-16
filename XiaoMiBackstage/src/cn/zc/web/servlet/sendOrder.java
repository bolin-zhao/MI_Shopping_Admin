package cn.zc.web.servlet;

import cn.zc.dao.UserDao;
import cn.zc.dao.impl.UserDaoImpl;
import cn.zc.domain.User;
import cn.zc.service.impl.OrderServiceImpl;
import cn.zc.utils.RandomUtils;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create By Bolin on ${DATA}
 * 发货后, 订单status变为3
 */
@WebServlet("/sendOrder")
public class sendOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取参数id,即订单编号
        String id = request.getParameter("id");
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.updateStatusById(id);
        response.getWriter().write("1");
    }
}

