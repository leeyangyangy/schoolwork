package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.TOrder;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:12
 * @Description:
 */
public interface TOrderMapper {

//    查询订单编号oid为1的订单信息
    TOrder findTOrderByOid(Integer oIds);
    List<TOrder> findAllOrderByCid(Integer cIds);
}
