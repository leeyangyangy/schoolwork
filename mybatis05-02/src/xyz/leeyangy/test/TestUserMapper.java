package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {

    //    1.模糊查询
    @Test
    public void testFindByLike() {
//    1.创建SqlSession对象
        SqlSession session = null;
        try {
//        2.获取session对象
            session = MybatisUtils.getSqlSession();
//          3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//          4.执行操作
            List<User> list = userMapper.findByLike("e");
            for (User user : list) {
                System.out.println(user);
            }
//            提交事务
            session.commit();
        } catch (Exception e) {
//        事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//        关闭session
            MybatisUtils.close(session);
        }
    }

    //    2.动态sql
    @Test
    public void testFindByDy() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setId(1);
            /**
             * 执行操作
             * 由于只有一个结果，故下小懒
             */
//            User user=userMapper.findByDy(user1);
            System.out.println(userMapper.findByDy(user1));
//            session.commit();
        } catch (Exception e) {
//            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

    //    3.插入主键返回
    @Test
    public void testInserrtBackKey() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
//        获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//        执行操作
            User user1 = new User();
            user1.setName("1");
            user1.setAge(22);
            user1.setBirthday(new Date());
            user1.setPassword("12345");
            int total = userMapper.addUser(user1);
//            提交事务
            System.out.println("插入" + total + "条记录" + "插入的id是:" + user1.getId());
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

}
