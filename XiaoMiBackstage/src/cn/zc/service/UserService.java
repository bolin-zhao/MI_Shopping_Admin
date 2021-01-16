package cn.zc.service;

import cn.zc.domain.User;

import java.util.List;

public interface UserService {
//    登陆功能
    User login(String username, String password);

//    查询所有用户激活状态
    List<User> findallByFlag(Integer flag,Integer pageSize,Integer pageCode);

    List<User> findallByNameOrId(String sers,Integer flag);

    int getCount(Integer flag);

    int update(User user,int flag);

    int add(User user);

    User findById(String id);

    void deleteById(int id);

    User findByUsername(String username);
}
