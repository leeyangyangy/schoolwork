package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {
    //查询
    @Test
    public void testFindByWhere() {
//        获取SqlSession
        SqlSession session = null;
        try {
//            获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User();
//            user.setId("14e37afc-41f9-47d2-8aa7-f2c430dcdfea");
//            user.setName("opqr");
            user.setAge(2);
//            user.setPassword("123");
            //            执行功能
            List<User> list = userMapper.findByWhere(user);
            for (User user1 : list) {
                System.out.println(user1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

    /**
     * 测试id
     * 14e37afc-41f9-47d2-8aa7-f2c430dcdfea
     * 4a850319-9c63-44ff-b615-32e210bbafcc
     * caa20873-a4de-4fe2-9d99-815c2a390162
     */
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
            user1.setId("caa20873-a4de-4fe2-9d99-815c2a390162");
            user1.setPassword("123321");
            user1.setName("Lee");
            user1.setAge(22);
//            执行功能
            int total = userMapper.updateUser(user1);
            System.out.println("更新了 " + total + " 条记录");
//            提交事务
            session.commit();
            List<User> list=userMapper.findByWhere(user1);
            System.out.println("查询到的信息:");
            for (User user:list){
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
}

