package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
//    1.查询所有用户
    public List<User> findAll();
//    2.根据id查询用户信息
    public User getUserById(int id);
}
