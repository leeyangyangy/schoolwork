package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Param;
import xyz.leeyangy.pojo.User;

import java.util.List;

public interface UserMapper {
    //    查询
    List<User> findByWhere(User user);

//    更新
    int updateUser(User user);
}
