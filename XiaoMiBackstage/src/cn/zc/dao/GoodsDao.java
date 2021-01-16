package cn.zc.dao;

import cn.zc.domain.Goods;

import java.util.List;

/**
 * @Author: bolin
 */
public interface GoodsDao {

    int getCount();

    List<Goods> findallByName(String sers);

    List<Goods> findAllGoods(Integer pageSize,Integer pageCode);

    int add(Goods goods);

    Goods findById(String id);

    void deleteById(int id);

    int editById(Goods goods);
}
