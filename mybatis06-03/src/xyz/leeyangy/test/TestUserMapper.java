package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {

    /**
     * 测试id
     * 14e37afc-41f9-47d2-8aa7-f2c430dcdfea
     * 4a850319-9c63-44ff-b615-32e210bbafcc
     * caa20873-a4de-4fe2-9d99-815c2a390162
     */

//    更新
    @Test
    public void testUpdate() {
        //        获取SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setName("Job");
            user1.setPassword("good");
            user1.setId("4a850319-9c63-44ff-b615-32e210bbafcc");
//            第一次查询原信息
//            List<User> list = userMapper.findUserByWhere(user1);
//            for (User user : list) {
//                System.out.println(user);
//            }
//            执行功能
            int total = userMapper.updateUser(user1);
            System.out.println(total);
//            事务提交
            session.commit();
//            再次做一次查询，查看是否修改成功
            List<User> list = userMapper.findUserByWhere(user1);
            for (User user : list) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            事务回滚
            session.rollback();
        } finally {
            MybatisUtils.close(session);
        }
    }


    //    查询
    @Test
    public void testFindUserByWHere() {
        //        获取SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user1 = new User();
            user1.setId("14e37afc-41f9-47d2-8aa7-f2c430dcdfea");
            user1.setName("opqr");
            user1.setPassword("12345");
//            执行功能
            List<User> list = userMapper.findUserByWhere(user1);
            for (User user : list) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }
}
