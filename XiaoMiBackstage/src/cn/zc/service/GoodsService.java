package cn.zc.service;

import cn.zc.domain.Goods;
import cn.zc.domain.User;

import java.util.List;

/**
 * @Author: bolin
 */
public interface GoodsService {

    int getCount();

    List<Goods> findallByName(String sers);

    List<Goods> findAllGoods(Integer pageSize,Integer pageCode);

    Goods findById(String id);

    void deleteById(int id);

    int editById(Goods goods);
}
