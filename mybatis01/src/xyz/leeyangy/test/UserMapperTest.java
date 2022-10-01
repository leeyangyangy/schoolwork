package xyz.leeyangy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

import xyz.leeyangy.pojo.User;

public class UserMapperTest {
    public static void main(String[] args) {
        try {
            // 1.       加载mybatis全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            2.      创建SqlSessionFactoryBuilder对象，称为SqlSessionFactory构建器
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            3.      创建SqlSessionFactory工厂对象，用于创建SqlSession对象
            SqlSessionFactory factory = builder.build(inputStream);
//            4.      创建SqlSession
            SqlSession session = factory.openSession();
//            5.        通过SqlSession对象实现对数据库的CURD操作

//            6.        测试查询所有信息
            List<User> list=session.selectList("myMapper.getAll");
//            遍历集合
            for(User user:list){
                System.out.println(user);
            }
////            提交事务
//            session.commit();
////            关闭资源
//            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
