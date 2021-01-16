package cn.zc.service.impl;

import cn.zc.dao.OrderDetailDao;

import cn.zc.dao.impl.OrderDetailDaoImpl;
import cn.zc.domain.Order;
import cn.zc.domain.OrderDetail;
import cn.zc.service.OrderDetailService;

import java.util.List;

/**
 * Create By Bolin on
 */
public class OrderDetailServiceImpl implements OrderDetailService {
   OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
    @Override
    public int getCount() {
        return orderDetailDao.getCount();
    }

    @Override
    public List<OrderDetail> findallByName(String sers) {
        return orderDetailDao.findallByName(sers);
    }

    @Override
    public List<OrderDetail> findAllOrder(Integer pageSize, Integer pageCode) {
        return orderDetailDao.findAllOrder(pageSize,pageCode);
    }
}
