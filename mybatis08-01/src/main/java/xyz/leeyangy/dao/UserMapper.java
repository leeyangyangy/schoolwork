package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.User;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 12:43
 * @Description:
 */
//接口实现方法
public interface UserMapper {
//    测试数组注入
    public List<User> findByArrayList(int arr[]);
//    foreach查询信息,有一堆id.....
    public List<User> findByList(List<Integer> list);
//    测试查询所有
    public List<User> findByDy(User user);
}
