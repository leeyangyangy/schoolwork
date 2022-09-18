package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
    //    查询所有用户信息
    public List<User> findAll();

    //    根据id查询用户信息
    public User findUserById(int id);

//    插入主键返回
    public int addUser(User user);

//    动态sql
//    查询
    public List<User> findByD(User user);

//    模糊查询
    public List<User> findByLike(String name);

}
