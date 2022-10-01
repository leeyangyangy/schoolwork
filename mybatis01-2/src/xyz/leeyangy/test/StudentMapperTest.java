package xyz.leeyangy.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.leeyangy.pojo.Student;

import java.io.InputStream;
import java.util.List;

public class StudentMapperTest {
    public static void main(String[] args) {
//        抛出异常
        try {
//            1.导入全局配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            2.创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            3.创建SqlSessionFactory对象
            SqlSessionFactory factory = builder.build(inputStream);
//            4.创建SqlSession对象
            SqlSession session = factory.openSession();
//            5.遍历
            List<Student> list = session.selectList("StudentMapper.getAll");
            for (Student student:list){
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
