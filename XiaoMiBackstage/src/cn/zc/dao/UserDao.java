package cn.zc.dao;

import cn.zc.domain.User;

import java.util.List;

public interface UserDao {

//    登陆功能
    User login(String username, String password);

//  获取数据总条数
    public int getCount(Integer flag);

// 搜索功能
    List<User> findallByNameOrId(String sers,Integer flag);

    // 更改激活状态
    int update(User user,int flag);

    // 查询所有激活/未激活用户
    List<User> findallByFlag(Integer flag,Integer pageSize,Integer pageCode);

    // 添加用户
    int add(User user);

    // 根据id查询
    User findById(String id);

    // 根据id删除
    void deleteById(int id);

    User findByUsername(String username);
}
