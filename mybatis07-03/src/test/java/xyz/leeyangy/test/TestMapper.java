package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 18:37
 * @Description:
 */
public class TestMapper {

    //    test list
    @Test
    public void testFindByList() {
//        1.创建SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper mapper = session.getMapper(UserMapper.class);
//            创建list集合
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(10);
            list1.add(256);
            list1.add(512);
//            执行功能
            List<User> list = mapper.findByList(list1);
            for (User user : list) {
                System.out.println(user);
            }
//            提交事务
//            session.commit();
        } catch (Exception e) {
//            回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }

    }

    //    test array
    @Test
    public void testFindByArray() {
//        1.创建SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper mapper = session.getMapper(UserMapper.class);
            int arr[] = {1, 3, 5, 7, 9, 256, 512, 1024};
//            执行功能
            List<User> list = mapper.findByArray(arr);
            for (User user : list) {
                System.out.println(user);
            }
//            提交事务
            session.commit();
        } catch (Exception e) {
//            回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }
}
