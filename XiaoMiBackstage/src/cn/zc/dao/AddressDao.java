package cn.zc.dao;

import cn.zc.domain.Address;

import java.util.List;

public interface AddressDao {

//    查找地址
    public List<Address> findByLevel(Integer uid);

//    添加地址
    void add(Address address);

//    设置默认地址
    void defaultAddress(Integer uid, Integer aid);

//    删除地址
    void deleteAddress(Integer id);

//    修改地址
    void updateAddress(Address address);
}
