package cn.zc.service;

import cn.zc.domain.Cart;

import java.util.List;

public interface CartService {

    Cart findByUidAndPid(Integer uid, Integer pid);

    void addCart(Cart cart1);

    void update(Cart cart);

    List<Cart> findByUid(Integer uid);

    void deleteByUidAndPid(Integer id, int pid);

    void clearById(Integer id);

}
