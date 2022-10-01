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
//    查询指定的客户以及关联订单信息
    @Test
    public void testFindCustomerAndOrderByCid(){
        //    获取SqlSession
        SqlSession session=null;
        try{
//            获取session
            session=MybatisUtils.getSqlSession();
//            获取接口
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
//            执行功能
            Customer customer = customerMapper.findCustomerAndOrderByCid(1);
            System.out.println(customer);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.close(session);
        }
    }
}
