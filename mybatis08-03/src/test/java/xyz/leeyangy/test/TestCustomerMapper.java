package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.CustomerMapper;
import xyz.leeyangy.pojo.Customer;
import xyz.leeyangy.pojo.TOrder;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:14
 * @Description:
 */
public class TestCustomerMapper {
    @Test
    public void testFindAll() {
        //    创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
//            执行功能
            List<Customer> list = customerMapper.findAll();
            for (Customer customer : list) {
                System.out.println(customer);
//                获取订单信息
                List<TOrder> list1 = customer.getOrderList();
                for (TOrder tOrder : list1) {
                    System.out.println(tOrder);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }
}
