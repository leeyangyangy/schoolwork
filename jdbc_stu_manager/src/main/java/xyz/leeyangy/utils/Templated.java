package xyz.leeyangy.utils;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Package: xyz.leeyangy.utils
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 1:07
 * @Description:
 */
public class Templated {
    @Test
    public void testFun() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象

//            执行功能


//            查询结果

//            提交事务
            session.commit();
        } catch (Exception e) {
//                事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//                关闭session
            MybatisUtils.close(session);
        }
    }
}
