package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.GradeMapper;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.pojo.Grade;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 11:28
 * @Description:
 */
public class TestGradeMapper {
    //    测试插入班级数据
    @Test
    public void testAddGrade() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
//            从控制台读入数据
            Scanner scGClass = new Scanner(System.in);
            String gClass;
            gClass = scGClass.nextLine();
            int total = 0;
//            执行功能
            Grade grade = gradeMapper.checkGradeInfo(gClass);
//            查询结果
            if (grade != null) {
                System.out.println("班级已存在!");
            } else if (grade == null) {
                total = gradeMapper.addGrade(gClass);
//                ----------------------------------------
                if (total > 0) {
                    System.out.println("添加班级成功");
                } else {
                    System.out.println("添加班级失败");
                }
//                ----------------------------------------
            } else {
                System.out.println("其它错误");
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

    //    测试插入班级数据
    @Test
    public void testDelAllStudentByGrade() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
//            String gClass="五班";
            String gClass = "八班";
            int total = 0;
//            执行功能
            Grade grade = gradeMapper.checkGradeInfo(gClass);
//            查询结果
            if (grade == null) {
                System.out.println("班级不存在,无法完成删除操作!");
            } else if (grade != null) {
                total = gradeMapper.delAllStudentByGrade(gClass);
//                ----------------------------------------
                if (total > 0) {
                    System.out.println("删除班级和该班级学生成功");
                } else {
                    System.out.println("删除班级失败");
                }
//                ----------------------------------------
            } else {
                System.out.println("其它错误");
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

    //    查询班级下所有学生
    @Test
    public void testFindAllStudentByGname() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
            String gName = "一班";
//            执行功能
//            检查班级是否存在
            Grade checkGradeInfo = gradeMapper.checkGradeInfo(gName);
            if (checkGradeInfo == null) {
                System.out.println("班级不存在，查询不到信息");
            } else {
                System.out.println("班级存在");
//                执行功能
                Grade grade = gradeMapper.findAllStudentByGname(gName);
//            查询结果
                System.out.println(grade);
                List<Student> list = grade.getStudentList();
                System.out.println("查到如下学生:");
                for (Student student : list) {
                    System.out.println(student.getSName());
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

    //    测试查询自己班级信息
    @Test
    public void test1() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
            Student sInfo = new Student();
            sInfo.setSId(999);
            sInfo.setSName("李洋洋");
//            执行功能
            Grade grade = gradeMapper.findMyGradeInfo(sInfo);

//            查询结果
            if (grade == null) {
                System.out.println("找不到班级");
            } else {
                System.out.println(grade.getGName() + " 班");
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
}
