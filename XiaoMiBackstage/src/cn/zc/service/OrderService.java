package cn.zc.service;

import cn.zc.domain.Order;

import java.util.List;

public interface OrderService {

    int getCount();

    List<Order> findallByName(String sers);

    List<Order> findAllOrder(Integer pageSize,Integer pageCode);

    void updateStatusById(String id);
}
