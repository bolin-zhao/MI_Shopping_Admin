package cn.zc.dao.impl;

import cn.zc.dao.GoodsDao;
import cn.zc.domain.Goods;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: bolin
 */
public class GoodsDaoImpl implements GoodsDao {
    // 查询商品类型列表
    @Override
    public List<Goods> findAllGoods(Integer pageSize,Integer pageCode) {
        List<Goods> goods = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int k = pageSize;
        pageSize = (pageCode-1)*pageSize;
        pageCode = k;
        Object [] params = {pageSize,pageCode};
        try {
            goods = qr.query("select *from tb_goods limit ?,?",new BeanListHandler<Goods>(Goods.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品列表失败",e);
        }
        return goods;
    }

    // 添加商品
    @Override
    public int add(Goods goods) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] params = {goods.getName(),goods.getPubdate(),goods.getPicture(),goods.getPrice(),goods.getStar(),goods.getIntro(),goods.getTypeid()};
        try {
            return qr.update("insert into tb_goods values(null,?,?,?,?,?,?,?)",params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败",e);
        }
    }

    // 查看商品参数
    @Override
    public Goods findById(String id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods where id =?",new BeanHandler<Goods>(Goods.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查找失败!",e);
        }
    }

    // 根据id删除商品
    @Override
    public void deleteById(int id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("SET foreign_key_checks = 0");
            qr.update("delete from tb_goods where id = ?",id);
            qr.update("SET foreign_key_checks = 1");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败!", e);
        }
    }

   //将格林尼治格式的日期转为yyyy-MM-dd格式
    public static String checkDate(String str){
        String format1 = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            Date date = new Date(str);
            format1 = format.format(date);
        } catch (Exception e) {
            throw  new RuntimeException("日期格式错误!请以"+"yyyy-mm-dd"+"格式填写日期");
        }
        return format1;
    }

    // 修改商品
    @Override
    public int editById(Goods goods) {
        String s = checkDate(goods.getPubdate().toString());
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] params = {goods.getName(),s,goods.getPicture(),goods.getPrice(),goods.getStar(),goods.getIntro(),goods.getTypeid(),goods.getId()};
        String sql="UPDATE tb_goods SET NAME=?,pubdate=?,picture=?,price=?,star=?,intro=?, typeid=? WHERE id=?";
        try {
            return qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改商品信息失败",e);
        }
    }



    // 获取商品总条数
    @Override
    public int getCount() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int result = 0;
        try {
            String sql = "select count(*) from tb_goods";
            result = ((Long) qr.query(sql, new ScalarHandler())).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户条数失败",e);
        }
        return result;
    }

    // 模糊查询商品
    @Override
    public List<Goods> findallByName(String sers) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_goods where name like ?",new BeanListHandler<Goods>(Goods.class),"%"+sers+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品列表失败",e);
        }
    }

}