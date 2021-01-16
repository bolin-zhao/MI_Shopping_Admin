package cn.zc.web.servlet;

import cn.zc.dao.UserDao;
import cn.zc.dao.impl.UserDaoImpl;
import cn.zc.domain.User;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Create By Bolin on ${DATA}
 * 修改用户激活/冻结
 */
@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取isFlag参数
        String str = request.getParameter("str");
        User user = JSONObject.parseObject(str, User.class);
        String flag1 = request.getParameter("isFlag");
        int flag = Integer.parseInt(flag1);
        // 设置flag值1/0
        user.setFlag(flag);
        UserDao userDao = new UserDaoImpl();
        int result = userDao.update(user,flag);
        if (result>0){
            response.getWriter().write(result);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

