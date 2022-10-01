package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.CustomerMapper;
import xyz.leeyangy.pojo.Customer;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/27 15:14
 * @Description:
 */
public class TestCustomerMapper {
    //    测试查询所有
    @Test
    public void testFIndAll() {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

}
