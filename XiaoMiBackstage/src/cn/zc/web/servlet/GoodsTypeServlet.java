package cn.zc.web.servlet;

import cn.zc.domain.Goods;
import cn.zc.domain.GoodsType;
import cn.zc.service.GoodsService;
import cn.zc.service.GoodsTypeService;
import cn.zc.service.impl.GoodsServiceImpl;
import cn.zc.service.impl.GoodsTypeServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends BaseServlet{
//   根据商品级别展示商品列表
    public String findAllGoodsType(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsType> lists = null;
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
        int result = goodsTypeService.getCount();
        if (sers != null){
            // 如果不为空,就模糊查询商品
            lists= goodsTypeService.findallByName(sers);
            jsonObject.put("count",0);
        }else {
            //如果为空,就显示所有商品
            lists = goodsTypeService.findAllGoodsType(limit,page);
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
