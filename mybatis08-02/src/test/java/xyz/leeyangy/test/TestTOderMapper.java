package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.TOrderMapper;
import xyz.leeyangy.pojo.TOrder;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:05
 * @Description:
 */
public class TestTOderMapper {
    //    查询订单编号oid为1的订单信息，同时关联查出顾客信息   一对一查询
    @Test
    public void testFindByOid() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            TOrderMapper orderMapper = session.getMapper(TOrderMapper.class);
//            执行功能
            TOrder tOrder = orderMapper.findOrderAndCustomerByOid(1);
//            获取oid=1的订单信息
            System.out.println(tOrder);
//            单独获取到顾客信息
            System.out.println(tOrder.getCustomers());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            关闭session连接
            MybatisUtils.close(session);
        }
    }

}
