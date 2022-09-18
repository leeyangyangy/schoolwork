package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
    //    查询所有用户信息
    public List<User> findAll();

    //    根据id查询用户信息
    public User getUserById(int id);

    //    根据id删除
    public int delUserById(int id);

    //    根据id修改
    public int updateUser(User user);

    //    增加
    public int addUser(User user);
}
