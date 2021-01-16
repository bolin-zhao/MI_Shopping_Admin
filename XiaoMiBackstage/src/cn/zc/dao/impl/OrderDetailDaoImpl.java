package cn.zc.dao.impl;

import cn.zc.dao.OrderDetailDao;

import cn.zc.domain.Order;

import cn.zc.domain.OrderDetail;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {


    @Override
    public int getCount() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int result = 0;
        try {
            String sql = "select count(*) from tb_orderdetail";
            result = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有订单详情条数失败",e);
        }
        return result;
    }

    @Override
    public List<OrderDetail> findallByName(String sers) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_orderdetail where name like ?",new BeanListHandler<OrderDetail>(OrderDetail.class),"%"+sers+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询订单详情列表失败",e);
        }
    }

    @Override
    public List<OrderDetail> findAllOrder(Integer pageSize, Integer pageCode) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int k = pageSize;
        pageSize = (pageCode-1)*pageSize;
        pageCode = k;
        Object [] params = {pageSize,pageCode};
        try {
            orderDetails = qr.query("select * from tb_orderdetail limit ?,?",new BeanListHandler<OrderDetail>(OrderDetail.class),params);
            // System.out.println("sql:"+orderDetails);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询订单详情列表失败",e);
        }
        return orderDetails;
    }
}
