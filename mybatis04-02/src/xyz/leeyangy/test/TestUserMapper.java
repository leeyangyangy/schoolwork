package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {
    @Test
//    1.测试查询所有学生
    public void testFindAllUser() {
//        1.获取SqlSession对象
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = userMapper.findAll();
//            4.遍历结果
            for (User user : list) {
                System.out.println(user);
            }
//            5.提交事务
            session.commit();
        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //    2.测试通过id查询用户
    @Test
    public void testFindById() {
//        1.获取SqlSession对象
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findUserById(2);
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //    3.通过name和password查询用户信息
    @Test
    public void testFindByNameAndPassword() {
//        1.获取sqlsession对象
        SqlSession session = null;
        try {
//          2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setPassword("1233");
            user1.setName("Lee");
            User user = userMapper.findUserByNameAndPassword(user1);
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //    4.通过name查询
    @Test
    public void testFindByName() {
        //        1.获取sqlsession对象
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//                3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findUserByName("Lee");
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }


    //        5.通过注解查询用户信息
    @Test
    public void testByParam() {
        //        1.获取sqlsession对象
        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User u1 = new User();
            u1.setName("Leeo");
            u1.setPassword("12333");
            User user = userMapper.findUserByNameAndPassword(u1);
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }
}

