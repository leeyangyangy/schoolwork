package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.TOrderMapper;
import xyz.leeyangy.pojo.TOrder;
import xyz.leeyangy.utils.MybatisUtils;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/27 15:14
 * @Description:
 */
public class TestOrderMapper {
    @Test
    public void testFindTOrderByOid() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            TOrderMapper orderMapper = session.getMapper(TOrderMapper.class);
//            执行功能
            TOrder tOrder = orderMapper.findTOrderByOid(1);
            System.out.println(tOrder);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }
}
