package cn.zc.dao.impl;

import cn.zc.dao.CartDao;
import cn.zc.domain.Cart;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CartDaoImpl implements CartDao {

//    根据客户id和商品id查找购物车信息
    @Override
    public Cart findByUidAndPid(Integer uid, Integer pid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_cart where id=? and pid=?",new BeanHandler<Cart>(Cart.class),uid,pid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据客户id和商品id查找购物车信息失败",e);
        }
    }

//    添加购物车信息
    @Override
    public void addCart(Cart cart1) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] parms = {cart1.getId(),cart1.getPid(),cart1.getNum(),cart1.getMoney()};
        try {
            qr.update("insert into tb_cart values(?,?,?,?)",parms);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加购物车信息失败",e);
        }
    }

//    修改购物车信息
    @Override
    public void update(Cart cart) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] parms = {cart.getNum(),cart.getMoney(),cart.getId(),cart.getPid()};
        try {
            qr.update("update tb_cart set Num=?,money=? where id=? and pid=?",parms);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改购物车信息失败",e);
        }
    }

//    根据客户id查询购物车数据集
    @Override
    public List<Cart> findByUid(Integer uid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_cart where id=?",new BeanListHandler<Cart>(Cart.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据客户id查询购物车数据集失败",e);
        }
    }

//    根据客户id和商品id删除数据
    @Override
    public void deleteByUidAndPid(Integer id, int pid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("delete from tb_cart where id=? and pid=?",id,pid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据客户id和商品id删除数据失败",e);
        }
    }

//    根据客户id清空购物车
    @Override
    public void clearById(Integer id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("delete from tb_cart where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("根据客户id清空购物车失败",e);
        }
    }
}
