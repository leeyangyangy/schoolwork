package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
    //    查询所有用户信息
    public List<User> findAll();

    //    根据id查询用户信息
    public User getUserById(int id);

    //    根据id查询用户信息
//    public List<User> getUserById2(int id);
}
