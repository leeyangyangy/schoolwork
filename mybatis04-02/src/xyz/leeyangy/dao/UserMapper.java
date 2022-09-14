package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
    //    查询所有用户信息
    List<User> findAll();

    //    根据id查询用户信息
    User findUserById(int id);

    public User findUserByNameAndPassword(User user);

    //    4.根据用户名查询指定用户信息
    public User findUserByName(String name);

    //    5.根据用户名和密码查询，通过注解实现用户名和密码查询
    public User findUserByParam(@Param("username") String name, @Param("password") String passwd);


}
