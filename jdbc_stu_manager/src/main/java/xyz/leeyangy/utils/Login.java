package xyz.leeyangy.utils;

import org.apache.ibatis.session.SqlSession;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.pojo.Student;

/**
 * @Package: xyz.leeyangy.utils
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 12:21
 * @Description: 登录系统
 */
public class Login {
    public void login(Student s) {
//        flag标记while死循环，输入其它数据就跳出死循环
        boolean flag = true;
        Commons commons = new Commons();
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//            执行功能
            Student student = studentMapper.Login(s);
//            先做查询，有数据checkstudent不为null,则认为查到数据
            Student checkStudent = studentMapper.checkStudent(s);
            if (checkStudent!=null && student.getIsAdmin() == 1) {
                System.out.println("登录为管理员");
                commons.admin_menu(s, flag);
            } else if (checkStudent!=null && student.getIsAdmin() == 0) {
                System.out.println("登录为普通学生");
//            调用学生commons
                commons.student_menu(s, flag);
            } else {
                System.out.println("登录失败, 学生id 和 姓名 错误!");
            }
//            提交事务
//            session.commit();
        } catch (
                Exception e) {
//                事务回滚
//            session.rollback();
            e.printStackTrace();
        } finally {
//                关闭session
            MybatisUtils.close(session);
        }
    }
}
