package cn.zc.dao.impl;

import cn.zc.dao.AddressDao;
import cn.zc.domain.Address;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {

//    查找地址
    @Override
    public List<Address> findByLevel(Integer uid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_address where uid=?",new BeanListHandler<Address>(Address.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据用户名查询查询地址错误",e);
        }
    }

//    添加地址功能
    @Override
    public void add(Address address) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] parms = {address.getDetail(),address.getName(),address.getPhone(),address.getUid(),address.getLevel()};
        try {
            qr.update("insert into tb_address(detail,name,phone,uid,level) values(?,?,?,?,?)",parms);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加地址失败",e);
        }
    }

//    设置默认地址
    @Override
    public void defaultAddress(Integer uid, Integer aid) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
//            把uid下面的所有level都设为0
            qr.update("update tb_address set level=0 where uid=?",uid);
//            把页面获取的id值的level设为1
            qr.update("update tb_address set level=1 where id=?",aid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("设置默认地址失败",e);
        }
    }

//    删除地址
    @Override
    public void deleteAddress(Integer id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("delete from tb_address where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除地址失败",e);
        }
    }

//    修改地址
    @Override
    public void updateAddress(Address address) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] parms = {address.getName(),address.getDetail(),address.getPhone(),address.getId()};
        try {
            qr.update("update tb_address set name=?,detail=?,phone=? where id=?",parms);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改地址信息失败",e);
        }
    }
}
