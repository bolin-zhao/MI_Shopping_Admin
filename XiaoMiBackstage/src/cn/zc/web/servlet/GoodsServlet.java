package cn.zc.web.servlet;

import cn.zc.dao.GoodsDao;
import cn.zc.dao.UserDao;
import cn.zc.dao.impl.GoodsDaoImpl;
import cn.zc.dao.impl.UserDaoImpl;
import cn.zc.domain.Goods;
import cn.zc.domain.PageBean;
import cn.zc.domain.User;
import cn.zc.service.GoodsService;
import cn.zc.service.UserService;
import cn.zc.service.impl.GoodsServiceImpl;
import cn.zc.service.impl.UserServiceImpl;
import cn.zc.utils.RandomUtils;
import cn.zc.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @Author: bolin
 */

@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
    // 查询所有商品
    public String findAllGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsService goodsService = new GoodsServiceImpl();
        List<Goods> lists = null;
        // 获取sers对象
        String sers = request.getParameter("sers");

        // 获取layUI分页功能页面传递的参数limit/page
        String limit0 = request.getParameter("limit");
        String page0 = request.getParameter("page");
        int limit = Integer.parseInt(limit0);
        int page = Integer.parseInt(page0);

        // 把数据转为json格式,去前端渲染
        JSONObject jsonObject = new JSONObject();

        // 获取总数据条数
        int result = goodsService.getCount();
        if (sers != null){
            // 如果不为空,就模糊查询商品
            lists= goodsService.findallByName(sers);
            jsonObject.put("count",0);
        }else {
            //如果为空,就显示所有商品
            lists = goodsService.findAllGoods(limit,page);
            // System.out.println(lists);
            jsonObject.put("count",result);
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");

        Object data = JSON.toJSON(lists);
        jsonObject.put("data",data);
        response.getWriter().write(jsonObject.toString());
        return null ;
    }


}
