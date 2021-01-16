package cn.zc.dao;

import cn.zc.domain.Goods;
import cn.zc.domain.GoodsType;

import java.util.List;

public interface GoodsTypeDao {

    List<GoodsType> findAll();

    int getCount();

    List<GoodsType> findallByName(String sers);

    List<GoodsType> findAllGoodsType(Integer pageSize,Integer pageCode);

    int add(GoodsType goodsType);

    void editById(GoodsType goodsType);

    GoodsType findById(String id);

    void deleteById(int id);
}
