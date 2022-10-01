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
 * @Create: 2022/9/30 23:15
 * @Description:
 */
public class TestTOrderMapper {
    //    查询所有订单及其关联的所有商品信息
    @Test
    public void testFindAllOrderAndProduct() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            TOrderMapper orderMapper = session.getMapper(TOrderMapper.class);
//            执行功能
            List<TOrder> list = orderMapper.findOrderAndProduct();
            for (TOrder tOrder : list) {
                System.out.println(tOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

    //    根据oid查询指定的订单以及关联的商品信息
    @Test
    public void testFindOrderAndProductByOid() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            TOrderMapper orderMapper = session.getMapper(TOrderMapper.class);
//            执行功能
             TOrder tOrder= orderMapper.findOrderAndProductByOid(4);
            System.out.println(tOrder);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }

    }
}
