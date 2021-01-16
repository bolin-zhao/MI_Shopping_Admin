package cn.zc.service.impl;

import cn.zc.dao.GoodsTypeDao;
import cn.zc.dao.impl.GoodsTypeDaoImpl;
import cn.zc.domain.GoodsType;
import cn.zc.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
//    由商品等级查询商品
GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();

    @Override
    public List<GoodsType> findAll() {
        return goodsTypeDao.findAll();
    }

    @Override
    public int getCount() {
        return goodsTypeDao.getCount();
    }

    @Override
    public List<GoodsType> findallByName(String sers) {
        return goodsTypeDao.findallByName(sers);
    }

    @Override
    public List<GoodsType> findAllGoodsType(int limit, int page) {
        return goodsTypeDao.findAllGoodsType(limit, page);
    }

    @Override
    public GoodsType findById(String id) {
        return goodsTypeDao.findById(id) ;
    }

    @Override
    public void deleteById(int id) {
        goodsTypeDao.deleteById(id);
    }
}
