package xyz.leeyangy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory factory = null;
//    静态代码块加载配置信息
    static {
        try{
//            加载mbatis全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            创建factory
            factory=new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    静态类加载静态方法
    public static SqlSession getSqlSession(){
//        创建session对象
//        SqlSession session=factory.openSession();
        return factory.openSession();
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
