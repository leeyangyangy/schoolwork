package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {

    //    1.查询所有
    @Test
    public void testFindAll() {
//    1.创建Sqlsession对象
        SqlSession session = null;
        try {
//        2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = userMapper.findAll();
            for (User user : list) {
                System.out.println(user);
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
//        关闭session
            MybatisUtils.close(session);
        }
    }

    //    2.按id查询
    @Test
    public void testFindUserById() {
        //    1.创建Sqlsession对象
        SqlSession session = null;
        try {
//        2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findUserById(1);
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
//        关闭session
            MybatisUtils.close(session);
        }
    }

    //
//    //    3，按name查询
    @Test
    public void testFindUserByName() {
        //    1.创建Sqlsession对象
        SqlSession session = null;
        try {
//        2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findUserByName("1313");
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
//        关闭session
            MybatisUtils.close(session);
        }
    }

    //
//    //    4.按name和password查询
    @Test
    public void testFindUserByNameAndPassword() {
        //    1.创建Sqlsession对象
        SqlSession session = null;
        try {
//        2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setName("ooo");
            user1.setPassword("123");
            User user = userMapper.findUserByNameAndPassword(user1);
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
//        关闭session
            MybatisUtils.close(session);
        }
    }

    //
    //    5.通过注解传参查询
    @Test
    public void testFindUserByParam() {
        //    1.创建Sqlsession对象
        SqlSession session = null;
        try {
//        2.获取session
            session=MybatisUtils.getSqlSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
//        3.获取接口对象
            user1.setName("abc");
            user1.setPassword("abc");
            User user = userMapper.findUserByParam(user1.getName(),user1.getPassword());
            System.out.println(user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
//        关闭session
            MybatisUtils.close(session);
        }
    }

}
