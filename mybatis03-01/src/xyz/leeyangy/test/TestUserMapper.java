package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Date;
import java.util.List;

public class TestUserMapper {


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
//               4.打印结果
            User user = userMapper.getUserById(162);
            System.out.println(user);
//            事务提交
            session.commit();
        } catch (Exception e) {
            session.rollback();
//               事务回滚
            e.printStackTrace();
        } finally {
//               关闭session
            MybatisUtils.close(session);
        }
    }


    //    查询所有
    @Test
    public void testFindAllUser() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//            2.获取session
            session = MybatisUtils.getSqlSession();
//            3.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> list = userMapper.findAll();
            for (User user : list) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.close(session);
        }
    }

//    @Test
//    public void testFindById(){
//        SqlSession session=null;
//        try{
//            session=MybatisUtils.getSqlSession();
//            UserMapper userMapper = session.getMapper(UserMapper.class);
//            User user=userMapper.findById(1);
//            System.out.println(user);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            MybatisUtils.close(session);
//        }
//    }

}
