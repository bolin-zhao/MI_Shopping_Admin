package cn.zc.web.servlet;

import cn.zc.dao.GoodsDao;
import cn.zc.dao.GoodsTypeDao;
import cn.zc.dao.impl.GoodsDaoImpl;
import cn.zc.dao.impl.GoodsTypeDaoImpl;
import cn.zc.domain.Goods;
import cn.zc.domain.GoodsType;
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
@WebServlet("/addGoodsType")
public class AddGoodsTypeServlet extends HttpServlet {
    // 添加商品
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取4个参数str
        String str = request.getParameter("str");
        GoodsType goodsType = JSONObject.parseObject(str, GoodsType.class);
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        goodsTypeDao.add(goodsType);
        // 打印添加的商品
        // System.out.println(goodsType);
        response.getWriter().write("1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

