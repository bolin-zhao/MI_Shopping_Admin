package cn.zc.service.impl;

import cn.zc.dao.AddressDao;
import cn.zc.dao.impl.AddressDaoImpl;
import cn.zc.domain.Address;
import cn.zc.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao = new AddressDaoImpl();
//    查询地址
    @Override
    public List<Address> findByUid(Integer uid) {
        return addressDao.findByLevel(uid);
    }

    //    添加地址
    @Override
    public void add(Address address) {
        addressDao.add(address);
    }

//       设置默认地址
    @Override
    public void defaultAddress(Integer uid, Integer aid) {
        addressDao.defaultAddress(uid,aid);
    }

//       删除地址
    @Override
    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);
    }

//    修改地址
    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }
}
