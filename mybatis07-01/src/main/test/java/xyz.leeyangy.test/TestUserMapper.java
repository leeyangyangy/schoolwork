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
 * @Create: 2022/9/26 12:49
 * @Description:
 */
public class TestUserMapper {
    //    测试查询所有
    @Test
    public void testFindAll() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setId(1);
//            执行功能
            List<User> list = userMapper.findByDy(user1);
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

    //    测试数组注入
    @Test
    public void testfFindByArrayList() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            数组注入
            int arr[] = {1, 2, 3, 4, 10110, 2};
//            执行功能
            List<User> list = userMapper.findByArrayList(arr);
            for (User user : list) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

    //    测试list注入
    @Test
    public void testFindByList() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            创建list集合，存放id数据
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(1001);
//            执行功能
            List<User> list1 = userMapper.findByList(list);
            for (User user : list1) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }
}
