package xyz.leeyangy.dao;

import java.util.List;

import xyz.leeyangy.pojo.User;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 17:32
 * @Description:
 */
public interface UserMapper {
    //    list集合
    List<User> findByList(List<Integer> list);

    //    array数组
    List<User> findByArray(int arr[]);

}
