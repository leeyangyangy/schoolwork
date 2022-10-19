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
 * @Create: 2022/9/30 23:16
 * @Description:
 */
public class TestTOrderMapper {

    //    一对一嵌套查询
    @Test
    public void testFindTOrderByOid() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            TOrderMapper orderMapper = session.getMapper(TOrderMapper.class);
//            4.执行功能
            TOrder order = orderMapper.findTOrderByOid(1);
//            5.查询结果
            System.out.println("第一次:"+order);
            System.out.println(order.getCustomer());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            6.关闭session
            MybatisUtils.close(session);
        }
    }

}
