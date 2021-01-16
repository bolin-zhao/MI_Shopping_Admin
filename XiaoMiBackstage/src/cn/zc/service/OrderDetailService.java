package cn.zc.service;

import cn.zc.domain.Order;
import cn.zc.domain.OrderDetail;

import java.util.List;

/**
 * Create By Bolin on
 */
public interface OrderDetailService {
    int getCount();

    List<OrderDetail> findallByName(String sers);

    List<OrderDetail> findAllOrder(Integer pageSize, Integer pageCode);
}
