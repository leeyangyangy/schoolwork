package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.Customer;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/27 15:12
 * @Description:
 */
public interface CustomerMapper {
//    一对多查询
    List<Customer> findAll();
}
