package xyz.leeyangy.test;

import com.sun.xml.internal.ws.api.pipe.NextAction;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.Scanner;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 11:28
 * @Description: 登录功能模块测试
 */
public class TestLogin {
    @Test
    public void testLogin() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Scanner scId=new Scanner(System.in);
            Scanner scStel=new Scanner(System.in);
            Integer sid=0;
            String stel;
            System.out.println("请输入登录学生id:");
//            sid=9999;
            sid=scId.nextInt();
            System.out.println("请输入登录学生手机号:");
//            stel="11111";
            stel=scStel.nextLine();
            Student s=new Student();
            s.setSId(sid);
            s.setSTel(stel);
//            执行功能
            Student student = studentMapper.Login(s);
//            查询结果
//            System.out.println(student);
            if(sid.equals(student.getSId()) && stel.equals(student.getSTel()) && student.getIsAdmin()==1){
                System.out.println("登录为管理员");
            } else if (sid.equals(student.getSId()) && stel.equals(student.getSTel()) && student.getIsAdmin()==0) {
                System.out.println("登录为普通学生");
            }else {
                System.out.println("登录失败,id和手机号错误!");
            }
//            提交事务
//            session.commit();
        } catch (Exception e) {
//                事务回滚
//            session.rollback();
            e.printStackTrace();
        } finally {
//                关闭session
            MybatisUtils.close(session);
        }
    }
}
