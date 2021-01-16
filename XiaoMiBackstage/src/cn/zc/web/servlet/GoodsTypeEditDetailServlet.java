package cn.zc.web.servlet;

import cn.zc.dao.GoodsDao;
import cn.zc.dao.GoodsTypeDao;
import cn.zc.dao.impl.GoodsDaoImpl;
import cn.zc.dao.impl.GoodsTypeDaoImpl;
import cn.zc.domain.Goods;
import cn.zc.domain.GoodsType;
import cn.zc.service.GoodsService;
import cn.zc.service.GoodsTypeService;
import cn.zc.service.impl.GoodsServiceImpl;
import cn.zc.service.impl.GoodsTypeServiceImpl;
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
@WebServlet("/goodsTypeDetails")
public class GoodsTypeEditDetailServlet extends HttpServlet {
    // 查看商品
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取页面传递的id值
        String id = request.getParameter("id");
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        GoodsType goodsType = goodsTypeService.findById(id);
        // 获取str
        String str = request.getParameter("str");

        // 就先显示所有数据,再让输入框里的数据可编辑
        if (str==null){
            request.setAttribute("goodsType", goodsType);
            request.getRequestDispatcher("goodsTypeDetail.jsp").forward(request, response);
        }else {
            goodsType = JSONObject.parseObject(str, GoodsType.class);
            GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
            goodsTypeDao.editById(goodsType);
            response.getWriter().write("1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

