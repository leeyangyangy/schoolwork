package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.TOrder;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/27 15:13
 * @Description:
 */
public interface TOrderMapper {
//    查询oid为1的订单信息，同时关联查询顾客信息
    TOrder findTOrderByOid(int oid);
}
