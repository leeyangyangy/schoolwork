package xyz.leeyangy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xyz.leeyangy.dao.UserMapper;
import xyz.leeyangy.pojo.User;

import java.io.InputStream;
import java.util.List;

public class TestUserMapper {
    @Test
    public void testFindAll() {
        try {
//            1.加载全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlseesionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            3.创建SqlSession对象
            SqlSession session = factory.openSession();
//            4.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            5.保存结果
            List<User> list = userMapper.findAll();
//            6.遍历
            for (User user : list) {
                System.out.println(user);
            }
//            关闭session
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserById() {
        try {
//            1.加载全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlseesionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//            3.创建SqlSession对象
            SqlSession session = factory.openSession();
//            4.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            5.保存结果
            User user = userMapper.getUserById(1);
//            6.打印结果
            System.out.println(user);
//            关闭session
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
