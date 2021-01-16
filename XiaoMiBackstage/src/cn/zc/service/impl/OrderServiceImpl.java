package cn.zc.service.impl;

import cn.zc.dao.OrderDao;
import cn.zc.dao.impl.OrderDaoImpl;
import cn.zc.domain.Order;
import cn.zc.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public int getCount() {
        return orderDao.getCount();
    }

    @Override
    public List<Order> findallByName(String sers) {
        return orderDao.findallByName(sers);
    }

    @Override
    public List<Order> findAllOrder(Integer pageSize,Integer pageCode) {
        return orderDao.findAllOrder(pageSize,pageCode);
    }

    @Override
    public void updateStatusById(String id) {
        orderDao.updateStatusById(id);
    }
}
