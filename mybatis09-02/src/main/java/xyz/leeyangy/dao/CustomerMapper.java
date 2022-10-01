package xyz.leeyangy.dao;

import xyz.leeyangy.pojo.Customer;
import xyz.leeyangy.pojo.TOrder;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:12
 * @Description:
 */
public interface CustomerMapper {
    //    查询指定的客户以及关联订单信息
    Customer findCustomerAndOrderByCid(int cid);
}
