package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.utils.MybatisUtils;
import xyz.leeyangy.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 17:42
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
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<Integer> list1 = new ArrayList<>();
//            向集合添加数据
            list1.add(1);
            list1.add(100);
            list1.add(2);
            list1.add(301);
//            执行功能
            List<User> list = userMapper.findByList(list1);
            for (User user : list) {
                System.out.println(user);
            }
//            提交事务
            session.commit();
        } catch (Exception e) {
//            回滚
//            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //   test array
    @Test
    public void testFindByArray() {
        //        1.创建SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int array[] = {1, 2, 3, 4, 5, 6, 7, 100, 9};
//            执行功能
            List<User> list = userMapper.findByArray(array);
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
