package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.TOrder;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:04
 * @Description:
 */
public interface TOrderMapper {
//    一对一查询，查询订单编号oid为1的订单信息，同时关联查出顾客信息
    TOrder findOrderAndCustomerByOid(int oid);
}
