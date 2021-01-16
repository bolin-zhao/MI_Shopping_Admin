package cn.zc.dao.impl;

import cn.zc.dao.GoodsTypeDao;
import cn.zc.domain.Goods;
import cn.zc.domain.GoodsType;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {


// 查询所有商品类型列表
    @Override
    public List<GoodsType> findAll() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods_type ", new BeanListHandler<GoodsType>(GoodsType.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品类型失败",e);
        }
    }

    // 获取总条数
    @Override
    public int getCount() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int result = 0;
        try {
            String sql = "select count(*) from tb_goods_type";
            result = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有商品类型条数失败",e);
        }
        return result;
    }

    // 模糊查询商品类型
    @Override
    public List<GoodsType> findallByName(String sers) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods_type where name like ?",new BeanListHandler<GoodsType>(GoodsType.class),"%"+sers+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品类型列表失败",e);
        }
    }

    @Override
    public List<GoodsType> findAllGoodsType(Integer pageSize,Integer pageCode) {
        List<GoodsType> goodsTypes = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int k = pageSize;
        pageSize = (pageCode-1)*pageSize;
        pageCode = k;
        Object [] params = {pageSize,pageCode};
        try {
            goodsTypes = qr.query("select * from tb_goods_type limit ?,?",new BeanListHandler<GoodsType>(GoodsType.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品列表失败",e);
        }
        return goodsTypes;
    }

    // 添加商品类型
    @Override
    public int add(GoodsType goodsType) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] params = {goodsType.getName(),goodsType.getLevel(),goodsType.getParent()};
        try {
            return qr.update("insert into tb_goods_type values(null,?,?,?)",params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败",e);
        }
    }

    @Override
    public void editById(GoodsType goodsType) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] params = {goodsType.getName(),goodsType.getLevel(),goodsType.getParent(),goodsType.getId()};
        try {
            qr.update("UPDATE tb_goods_type set name=?,level=?,parent=? where id=?",params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败",e);
        }
    }

    @Override
    public GoodsType findById(String id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods_type where id =?",new BeanHandler<GoodsType>(GoodsType.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查找失败!",e);
        }
    }

    // 根据id删除商品类型
    @Override
    public void deleteById(int id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("delete from tb_goods_type where id =?",id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败!",e);
        }
    }
}
