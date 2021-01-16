package cn.zc.web.servlet;

import cn.zc.dao.UserDao;
import cn.zc.dao.impl.UserDaoImpl;
import cn.zc.domain.User;
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
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取4个参数str
        String str = request.getParameter("str");
        User user = JSONObject.parseObject(str, User.class);
        UserDao userDao = new UserDaoImpl();
        user.setFlag(1);
        user.setRole(0);
        user.setCode(RandomUtils.createActive());
        // System.out.println(user);
        userDao.add(user);
        response.getWriter().write("1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

