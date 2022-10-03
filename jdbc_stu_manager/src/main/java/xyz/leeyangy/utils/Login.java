package xyz.leeyangy.utils;

import org.apache.ibatis.session.SqlSession;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.pojo.Student;

import java.util.Scanner;

/**
 * @Package: xyz.leeyangy.utils
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 12:21
 * @Description: 登录系统
 */
public class Login {
    public void login() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Scanner scId = new Scanner(System.in);
            Scanner scStel = new Scanner(System.in);
            Integer sid = 0;
            String sName;
            System.out.println("请输入登录学生id:");
//            sid=9999;
            sid = scId.nextInt();
            System.out.println("请输入登录学生姓名:");
//            stel="11111";
            sName = scStel.nextLine();
            Student s = new Student();
            s.setSId(sid);
            s.setSTel(sName);
//            执行功能
            Student student = studentMapper.Login(s);
//            显示菜单
            Display display = new Display();
//            查询结果
//            System.out.println(student);
            if (sid.equals(student.getSId()) && sName.equals(student.getSName()) && student.getIsAdmin() == 1) {
                System.out.println("登录为管理员");
                display.Display_Admin();
            } else if (sid.equals(student.getSId()) && sName.equals(student.getSName()) && student.getIsAdmin() == 0) {
                System.out.println("登录为普通学生");
                display.Display_Stu();
            } else {
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
