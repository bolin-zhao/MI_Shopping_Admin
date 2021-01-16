package cn.zc.service.impl;

import cn.zc.dao.GoodsDao;
import cn.zc.dao.impl.GoodsDaoImpl;
import cn.zc.dao.impl.GoodsTypeDaoImpl;
import cn.zc.domain.Goods;
import cn.zc.domain.GoodsType;
import cn.zc.domain.PageBean;
import cn.zc.domain.User;
import cn.zc.service.GoodsService;

import java.util.List;

/**
 * @Author: BOLIN *
 */
public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao=new GoodsDaoImpl();

    // 查找商品列表
    @Override
    public List <Goods> findAllGoods(Integer pageSize,Integer pageCode) {
        return goodsDao.findAllGoods(pageSize,pageCode);
    }

    @Override
    public Goods findById(String id) {
        return goodsDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        goodsDao.deleteById(id);
    }

    @Override
    public int editById(Goods goods) {
        return goodsDao.editById(goods);
    }

    @Override
    public int getCount() {
        return goodsDao.getCount();
    }

    @Override
    public List<Goods> findallByName(String sers) {
        return goodsDao.findallByName(sers);
    }

}
