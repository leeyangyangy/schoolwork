package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {

//    插入主键返回
    public int addUser(User user);

//    动态sql
//    查询
    public List<User> findByDy(User user);

//    模糊查询
    public List<User> findByLike(String name);

//    id查询
    public User findById(Integer id);

}
