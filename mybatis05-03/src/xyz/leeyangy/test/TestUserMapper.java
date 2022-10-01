package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {

    //    模糊查询
    @Test
    public void testFindByLike() {
//    创建SqlSession对象
        SqlSession session = null;
//   捕获....
        try {
//        获取session对象
            session = MybatisUtils.getSqlSession();
//        获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//        执行操作
            List<User> list = userMapper.findByLike("p");
            for (User user : list) {
                System.out.println(user);
            }
//        commit session
            session.commit();
        } catch (Exception e) {
//        session rollback
            session.rollback();
            e.printStackTrace();
        } finally {
//        close session connect
            MybatisUtils.close(session);
        }
    }

    //    动态sql查询
    @Test
    public void testDynamicFindUser() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session对象
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setId(30);
            user1.setAge(2);
            user1.setName("opq");
            user1.setPassword("12345");
//            执行操作
            List<User> list = userMapper.findByDy(user1);
            for (User user : list) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }


    //    插入主键返回
    @Test
    public void testInsertReturnKeyId() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session对象
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setAge(2);
            user1.setPassword("123");
            user1.setName("opq");
//            user1.setBirthday(new Date());
            int total = userMapper.addUser(user1);
            System.out.println("插入" + total + "条记录\n" + "插入的id是:" + user1.getId());

//            提交事务
            session.commit();
//            User user1 = mapper.findById(user.getId());
//            System.out.println(user1.toString());
//            System.out.println(user.toString());
            List<User> list = userMapper.findByDy(user1);
            System.out.println("查询到的记录:");
            for (User user2 : list) System.out.println(user2);

        } catch (Exception e) {
//            事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }
}

