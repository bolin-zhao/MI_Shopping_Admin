package cn.zc.dao;

import cn.zc.domain.Order;
import cn.zc.domain.OrderDetail;

import java.util.List;

/**
 * Create By Bolin on
 */
public interface OrderDetailDao {
    int getCount();

    List<OrderDetail> findallByName(String sers);

    List<OrderDetail> findAllOrder(Integer pageSize, Integer pageCode);
}
