package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.SubjectMapper;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.pojo.Subject;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 11:28
 * @Description:
 */
public class TestSubjectMapper {
    //    检查选课是否存在
    @Test
    public void testCheckSubject() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
//            执行功能
            Subject subject = subjectMapper.checkSubject("计算机网络");
//            查询结果
            System.out.println("subject valuse:" + subject);
            if (subject == null) {
                System.out.println("课程不存在可以添加");
            } else {
                System.out.println("课程已经存在，不允许重复添加");
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

    //    添加选课
    @Test
    public void testAddSubject() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
            String subName = "计算机组成原理";
            int total;
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
//            执行功能
            Subject subject = subjectMapper.checkSubject(subName);
//            查询结果
            System.out.println("subject valuse:" + subject);
            if (subject == null) {
                System.out.println("课程不存在可以添加");
//          -----------------------------------------
//                执行添加课程
                if (subjectMapper.addSubject(subName) > 0) {
                    System.out.println("添加选课成功!!!");
                } else {
                    System.out.println("添加选课失败");
                }
//          -----------------------------------------

            } else {
                System.out.println("课程已经存在，不允许重复添加");
            }
//            查询结果

//            提交事务
            session.commit();
        } catch (Exception e) {
//                事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//                关闭session
            MybatisUtils.close(session);
        }
    }

    //    删除选课
    @Test
    public void testDelSubject() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
            String subName = "组成原理";
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
//            执行功能
            Subject subject = subjectMapper.checkSubject(subName);
//            查询结果
            System.out.println("subject valuse:" + subject);
            if (subject == null) {
                System.out.println("课程不存在，不允许删除");
            } else {
                System.out.println("课程存在可以删除");
//          -----------------------------------------
//                执行添加课程
                if (subjectMapper.delSubject(subName) > 0) {
                    System.out.println("删除选课成功!!!");
                } else {
                    System.out.println("删除选课失败");
                }
//          -----------------------------------------
            }

//            提交事务
            session.commit();
        } catch (Exception e) {
//                事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//                关闭session
            MybatisUtils.close(session);
        }
    }

    //    查询该选课下的所有学生
    @Test
    public void testFindAllStudentBySubject() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
            String subName = "ssm框架开发技术";
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);
//            执行功能
            Subject subjectInfo = subjectMapper.checkSubject(subName);
//            查询结果
            System.out.println(subjectInfo);
            if (subjectInfo == null) {
                System.out.println("查询失败,没有该选课");
            } else {
//                执行功能
                Subject subject = subjectMapper.findAllStudentBySubject(subName);
                List<Student> list = subject.getStudentList();
                System.out.println("查询选课成功,学生如下:");
                for (Student student : list) {
                    System.out.println("学号:" + student.getSId() + " 姓名:" + student.getSName() + " 电话:" + student.getSTel());
                }
            }
//            提交事务
            session.commit();
        } catch (Exception e) {
//                事务回滚
            session.rollback();
            e.printStackTrace();
        } finally {
//                关闭session
            MybatisUtils.close(session);
        }
    }

    @Test
    public void test(){

    }

}
