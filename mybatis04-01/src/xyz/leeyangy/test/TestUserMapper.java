package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {
    //1.查询所有
    @Test
    public void testFindAll() {
//    1.声明SqlSeesion对象为null
        SqlSession session = null;
        try {
            //    2.获取session
            session = MybatisUtils.getSqlSession();
            //    3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = userMapper.findAll();
            //    4.查询结果
            for (User user : list) {
                System.out.println(user);
            }
//            提交事务
//            session.commit();
        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
            //    关闭session
            MybatisUtils.close(session);
        }
    }


    //    2.通过id查询
    @Test
    public void testFindUserById() {
        //        1.声明Sqlseeion
        SqlSession session = null;
        try {
//         2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//        4.遍历结果
            User user = userMapper.findUserById(1);
            System.out.println(user);
//            提交事务
//            session.commit();
        } catch (Exception e) {
            //            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //3.通过name和password查询
    @Test
    public void testFindByNameAndPassword() {
        //        1.声明Sqlseeion
        SqlSession session = null;
        try {
//         2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//        4.遍历结果
            User user1 = new User();
            user1.setName("Lee");
            user1.setPassword("1233");
            User user = userMapper.findByNameAndPassword(user1);
            System.out.println(user);
//            提交事务
//            session.commit();
        } catch (Exception e) {
            //            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //    4.根据用户名查询指定用户信息
    @Test
    public void testFindUserByName() {
//        1.创建SqlSeesion
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findUserByName("Leeo");
//            保存结果
            System.out.println(user);
//            提交事务
//            session.commit();
        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//            关闭session
            MybatisUtils.close(session);
        }
    }

    //    5.根据用户名和密码查询，通过注解实现用户名和密码查询
    @Test
    public void testFindUserByParam() {
//        1.创建SqlSeesion
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findUserByParam("Lee", "1233");
            System.out.println(user);
//            提交事务
//        session.commit();
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
