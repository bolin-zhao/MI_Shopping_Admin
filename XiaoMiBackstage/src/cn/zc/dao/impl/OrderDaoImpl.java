package cn.zc.dao.impl;

import cn.zc.dao.OrderDao;
import cn.zc.domain.Goods;
import cn.zc.domain.Order;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int getCount() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int result = 0;
        try {
            String sql = "select count(*) from tb_order";
            result = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户条数失败",e);
        }
        return result;
    }

    @Override
    public List<Order> findallByName(String sers) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_order where name like ?",new BeanListHandler<Order>(Order.class),"%"+sers+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询订单列表失败",e);
        }
    }

    @Override
    public List<Order> findAllOrder(Integer pageSize, Integer pageCode) {
        List<Order> order = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int k = pageSize;
        pageSize = (pageCode-1)*pageSize;
        pageCode = k;
        Object [] params = {pageSize,pageCode};
        try {
            order = qr.query("select * from tb_order limit ?,?",new BeanListHandler<Order>(Order.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询订单列表失败",e);
        }
        return order;
    }

    // 发货,修改status=3
    @Override
    public void updateStatusById(String id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Object [] params = {"3",id};
            qr.update("update tb_order set status=? where id=? ", params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据id修改状态值失败!", e);
        }
    }
}
