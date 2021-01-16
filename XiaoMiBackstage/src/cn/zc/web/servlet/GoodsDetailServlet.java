package cn.zc.web.servlet;

import cn.zc.dao.GoodsDao;
import cn.zc.dao.impl.GoodsDaoImpl;
import cn.zc.domain.Goods;
import cn.zc.domain.User;
import cn.zc.service.GoodsService;
import cn.zc.service.UserService;
import cn.zc.service.impl.GoodsServiceImpl;
import cn.zc.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Create By Bolin on ${DATA}
 */
@WebServlet("/goodsDetails")
public class GoodsDetailServlet extends HttpServlet {
    // 查看商品
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取页面传递的id值
        String id = request.getParameter("id");
        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.findById(id);
        //获取flag值
        String flag = request.getParameter("flag");
        request.setAttribute("flag", flag);
        // 获取str
        String str = request.getParameter("str");
        System.out.println(id);
        if (str==null){
            //字符串str为空,就插入数据,并查看
            request.setAttribute("goods", goods);
            //System.out.println(goods);
            request.getRequestDispatcher("goodsDetail.jsp").forward(request, response);
        }else{
            System.out.println(id);
            // request.setAttribute("goods", goods);
            // str不为空, 就先显示所有数据,再让输入框里的数据可编辑
            goods = JSONObject.parseObject(str, Goods.class);
            GoodsDao goodsDao = new GoodsDaoImpl();
            goodsDao.editById(goods);
            response.getWriter().write("1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

