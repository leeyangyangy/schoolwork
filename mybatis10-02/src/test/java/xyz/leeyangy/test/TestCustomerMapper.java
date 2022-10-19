package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.CustomerMapper;
import xyz.leeyangy.pojo.Customer;
import xyz.leeyangy.utils.MybatisUtils;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:16
 * @Description:
 */
public class TestCustomerMapper {
    //    一对一嵌套查询
    @Test
    public void testFindCustomerAndOrderByOid() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
//            4.执行功能
            Customer customer = customerMapper.findCustomerByCid(3);
//            5.查询结果
            System.out.println("第二次:"+customer);
            System.out.println(customer.getOrderList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            6.关闭session
            MybatisUtils.close(session);
        }
    }
}
