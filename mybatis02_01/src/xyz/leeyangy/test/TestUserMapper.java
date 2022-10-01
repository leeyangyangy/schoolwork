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
    //    测试查询所有用户信息
    @Test
    public void findAll() {
        try {
//            1.加载mybatis全局配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlSeesionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//            3.创建SqlSession对象
            SqlSession session = factory.openSession();
//            4.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            保存结果
            List<User> list = userMapper.findAll();
//            遍历
            for (User user : list) {
                System.out.println(user);
            }
//            关闭session
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    测试 按id查询用户信息
    @Test
    public void getUserById() {
        try {
//            1.加载mybatis全局配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlSessionfactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//            3.创建SqlSeesion对象
            SqlSession session = factory.openSession();
//            4.获取接口对象
            UserMapper userMapper = session.getMapper(UserMapper.class);
//            5.保存查询到的结果
            User user = userMapper.getUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
