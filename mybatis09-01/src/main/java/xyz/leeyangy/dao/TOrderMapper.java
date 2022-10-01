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
    //    查询所有订单及其关联的所有商品信息
    List<TOrder> findOrderAndProduct();

    //    根据oid查询指定的订单以及关联的商品信息
    TOrder findOrderAndProductByOid(Integer oid);
}
