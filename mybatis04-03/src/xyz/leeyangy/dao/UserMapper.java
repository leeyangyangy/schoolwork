package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
    //    查询所有用户信息
    public List<User> findAll();

    //    根据id查询用户信息
    public User findUserById(int id);

    //    根据name查询
    public User findUserByName(String name);

    //    根据name和password查询
    public User findUserByNameAndPassword(User user);

    //    通过注解入参查询
    public User findUserByParam(@Param("username") String name, @Param("password") String password);

}
