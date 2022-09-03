package xyz.leeyangy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.leeyangy.pojo.Emp;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    public static void main(String[] args) {
        try {
            //    1.导入mybatis全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            3.创建SqlSeesionFactory对象
            SqlSessionFactory factory = builder.build(inputStream);
//            4.创建Sqlsession对象
            SqlSession session = factory.openSession();
//            5.遍历
            List<Emp> list = session.selectList("myBatis.getAll");
            for (Emp emps : list) {
                System.out.println(emps);
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
