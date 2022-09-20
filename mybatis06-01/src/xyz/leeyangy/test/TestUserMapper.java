package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {

    //    1.动态sql
    @Test
    public void testFindUserById() {
        //    1.创建Sqlsession对象
        SqlSession session = null;
        try {
//        2.获取session
            session = MybatisUtils.getSqlSession();
//        3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setId("1");
            user1.setName("Lee");
            user1.setPassword("123321");
            user1.setAge(22);
//        user1.setBirthday(new Date());
//           4. 执行操作
            List<User> list = userMapper.findByD(user1);
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

    @Test
    public void testLogin() {
//        获取SqlSession对象
        SqlSession session = null;
        try {
//            获取session对象
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setName("Lee");
            user1.setPassword("123321");
//            执行login
            User user = userMapper.login(user1);
            System.out.println("查询到的数据:\n" + user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }

    }

    //    3.更新数据
//    测试id 6f6d5be0-1974-49c8-afa2-5997def6bf44
    @Test
    public void testUpdateUser() {
//        创建SqlSession对象
        SqlSession session = null;
        try {
//            获取session对象
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setId("6f6d5be0-1974-49c8-afa2-5997def6bf44");
            user1.setName("Hello");
            user1.setPassword("10010");
            user1.setBirthday(new Date());
//            执行update
            int total = userMapper.updateUser(user1);
            System.out.println("更新 " + total + " 条数");
//            提交事务
            session.commit();
//            查询是否修改了？
            System.out.println("查询到数据:"+userMapper.findByD(user1));
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
