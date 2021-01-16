package cn.zc.service;

import cn.zc.domain.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    List<GoodsType> findAll();

    int getCount();

    List<GoodsType> findallByName(String sers);

    List<GoodsType> findAllGoodsType(int limit, int page);

    GoodsType findById(String id);

    void deleteById(int id);
}
