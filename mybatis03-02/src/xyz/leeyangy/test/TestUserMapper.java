package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {
    //    增
    @Test
    public void testAddUser() {
        //        1.声明SqlSession
        SqlSession session = null;
        try {
//               2.获取session
            session = MybatisUtils.getSqlSession();
//               3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User u1 = new User();
//            u1.setId(162);
            u1.setName("ooo");
            u1.setPassword("10010");
            u1.setAge(23);
            u1.setBirthday(new Date());
            int total = userMapper.addUser(u1);
            System.out.println("total:" + total);
//            提交事务
            session.commit();
//               4.打印结果
        } catch (Exception e) {
//               事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//               关闭session
            MybatisUtils.close(session);
        }
    }

    //    删
    @Test
    public void testDelUserById() {
//        1.声明SqlSession
        SqlSession session = null;
        try {
//               2.获取session
            session = MybatisUtils.getSqlSession();
//               3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int total = userMapper.delUserById(166);
//               4.打印结果
            System.out.println("total:" + total);
//            事务提交
            session.commit();
        } catch (Exception e) {
//               事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//               关闭session
            MybatisUtils.close(session);
        }
    }

    //    改
    @Test
    public void updateUserById() {
//        1.声明SqlSession
        SqlSession session = null;
        try {
//               2.获取session
            session = MybatisUtils.getSqlSession();
//               3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User u1 = new User();
            u1.setId(162);
            u1.setName("asdadf");
            u1.setPassword("1123110");
            u1.setAge(53);
            u1.setBirthday(new Date());
//               4.打印结果
            int total = userMapper.updateUser(u1);
            System.out.println("total:" + total);
//            事务提交
            session.commit();
        } catch (Exception e) {
//               事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//               关闭session
            MybatisUtils.close(session);
        }
    }

    //    id查
    @Test
    public void getUserById() {
//        1.声明SqlSession
        SqlSession session = null;
        try {
//               2.获取session
            session = MybatisUtils.getSqlSession();
//               3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getUserById(162);
            System.out.println(user);
//            提交事务
            session.commit();
//               4.打印结果
        } catch (Exception e) {
//               事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//               关闭session
            MybatisUtils.close(session);
        }
    }

    //    查询所有
    @Test
    public void testFindall() {
//        1.声明Sqlseeion
        SqlSession session = null;
        try {
            //        2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//        4.遍历结果
            List<User> list = userMapper.findAll();
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

