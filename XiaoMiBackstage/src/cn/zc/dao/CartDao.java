package cn.zc.dao;

import cn.zc.domain.Cart;

import java.util.List;

public interface CartDao {

    Cart findByUidAndPid(Integer uid, Integer pid);

    void addCart(Cart cart1);

    void update(Cart cart);

    List<Cart> findByUid(Integer uid);

    void deleteByUidAndPid(Integer uid, int pid);

    void clearById(Integer id);
}
