package cn.zc.web.servlet;

import cn.zc.domain.*;

import cn.zc.service.OrderService;

import cn.zc.service.impl.OrderServiceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet {

//    获取订单页面
    public String getOrderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        OrderService orderService = new OrderServiceImpl();
        List<Order> lists = null;

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
        int result = orderService.getCount();
        System.out.println(result);
        if (sers != null){
            // 如果不为空,就模糊查询订单
            lists= orderService.findallByName(sers);
            jsonObject.put("count",0);
        }else {
            //如果为空,就显示所有订单
            lists = orderService.findAllOrder(limit,page);
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