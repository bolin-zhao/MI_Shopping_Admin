package cn.zc.service.impl;

import cn.zc.dao.CartDao;
import cn.zc.dao.impl.CartDaoImpl;
import cn.zc.domain.Cart;
import cn.zc.domain.Goods;
import cn.zc.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();
//   根据用户id和商品id获取购物车数据
    @Override
    public Cart findByUidAndPid(Integer uid, Integer pid) {
        return cartDao.findByUidAndPid(uid,pid);
    }

//   添加购物车数据
    @Override
    public void addCart(Cart cart1) {
        cartDao.addCart(cart1);
    }

//    修改购物车数据
    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }

//   根据用户id查找购物车商品信息合集
    @Override
    public List<Cart> findByUid(Integer uid) {
        List<Cart> cartList = cartDao.findByUid(uid);

        //找到goods对象
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        for (Cart cart : cartList) {
            //Goods goods = goodsService.findByGid(cart.getPid());
            //cart.setGoods(goods);
        }
        return cartList;
    }

//   根据用户id和商品id删除数据
    @Override
    public void deleteByUidAndPid(Integer id, int pid) {
        cartDao.deleteByUidAndPid(id,pid);
    }

//    根据客户id清空购物车
    @Override
    public void clearById(Integer id) {
        cartDao.clearById(id);
    }
}
