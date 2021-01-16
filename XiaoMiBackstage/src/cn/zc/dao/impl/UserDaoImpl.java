package cn.zc.dao.impl;

import cn.zc.dao.UserDao;
import cn.zc.domain.User;
import cn.zc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
//    根据用户名查找user表
    @Override
    public User findByUsername(String username) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_user where username=?",new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据用户名查找用户失败",e);
        }
    }

//   登录功能  根据密码和姓名进行查找
    @Override
    public User login(String username, String password) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select *from tb_user where username=? and password=?",new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("登陆失败",e);
        }
    }

//    查询所有未激活用户
    @Override
    public List<User> findallByFlag(Integer flag,Integer pageSize,Integer pageCode) {
        List<User> user = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from tb_user where flag=? limit ?,?";
        int k = pageSize;
        pageSize = (pageCode-1)*pageSize;
        pageCode = k;
        Object [] params = {flag,pageSize,pageCode};
        try {
            user = qr.query(sql,new BeanListHandler<User>(User.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有未激活用户失败",e);
        }
        return user;
    }

    // 获取数据总共有多少条
    @Override
    public int getCount(Integer flag) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        int result = 0;
        try {
            String sql = "select count(*) from tb_user where flag=?";
            result = ((Long) qr.query(sql, new ScalarHandler(),flag)).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户条数失败",e);
        }
        return result;
    }


//    搜索功能
    @Override
    public List<User> findallByNameOrId(String sers,Integer flag) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where username like ? and flag = ?",new BeanListHandler<User>(User.class),"%"+sers+"%",flag);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("搜索功能失败",e);
        }
    }

    // 更改用户状态为激活
    @Override
    public int update(User user,int flag) {
        int result = 0;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] params = {flag,user.getId()};
        try {
           result = qr.update("update tb_user set flag = ? where id = ?",params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("激活失败",e);
        }
        return result;
    }

    // 添加管理员
    @Override
    public int add(User user) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        Object [] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode()};
        try {
           return qr.update("insert into tb_user values(null,?,?,?,?,?,?,?)",params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("激活失败",e);
        }
    }

    // 查看用户参数
    @Override
    public User findById(String id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where id =?",new BeanHandler<User>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查找失败!",e);
        }
    }

    // 删除用户
    @Override
    public void deleteById(int id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            qr.update("SET foreign_key_checks = 0");
            qr.update("delete from tb_user where id = ?",id);
            qr.update("SET foreign_key_checks = 1");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败!", e);
        }
    }
}
