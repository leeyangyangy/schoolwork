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
//    根据cid查询指定顾客信息
    Customer findCustomerByCid(Integer cIds);
}
