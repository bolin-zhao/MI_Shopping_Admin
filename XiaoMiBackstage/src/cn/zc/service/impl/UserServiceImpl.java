package cn.zc.service.impl;

import cn.zc.dao.impl.UserDaoImpl;
import cn.zc.domain.User;
import cn.zc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

//    登录
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

//    查找对象的激活状态
    @Override
    public List<User> findallByFlag(Integer flag,Integer pageSize,Integer pageCode) {
        return userDao.findallByFlag(flag,pageSize,pageCode);
    }

//    搜索框功能
    @Override
    public List<User> findallByNameOrId(String sers,Integer flag) {
        return userDao.findallByNameOrId(sers,flag);
    }

    // 获取用户数据总条数
    @Override
    public int getCount(Integer flag) {
        return userDao.getCount(flag);
    }

    @Override
    public int update(User user,int flag) {
         return userDao.update(user,flag);
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
