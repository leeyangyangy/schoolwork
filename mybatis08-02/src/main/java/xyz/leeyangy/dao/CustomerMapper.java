package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.Customer;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:04
 * @Description:
 */
public interface CustomerMapper {
//    查询所有客户及其关联的所有订单信息
//    List<Customer> findAllCustomerAndOrder();
    List<Customer> findAll();
}
