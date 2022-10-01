package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 18:24
 * @Description:
 */
public interface UserMapper {
//    list
    List<User> findByList(List<Integer> list);

//    array
    List<User> findByArray(int arr[]);


}
