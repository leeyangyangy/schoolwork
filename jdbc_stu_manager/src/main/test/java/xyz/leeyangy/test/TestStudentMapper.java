package xyz.leeyangy.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.pojo.Grade;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * @Package: xyz.leeyangy.test
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 11:28
 * @Description: 测试学生信息增删改查模块是否正确
 */
public class TestStudentMapper {
    //    查询个人信息
    @Test
    public void testFun() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student sInfo = new Student();
            sInfo.setSId(9999);
            sInfo.setSName("李洋洋");
//            执行功能
            Student student = studentMapper.findSelfInfoBySnameAndSid(sInfo);
//            查询结果
//            System.out.println(student);
            System.out.println("学生信息\nid:" + student.getSId() + "\n姓名:" +
                    student.getSName() + "\n班级:" + student.getSGid() + "班");
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

    //    测试查询学生个人信息和学生选课信息
    @Test
    public void testFIndStudentInfo() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student sInfo = new Student();
            sInfo.setSName("李洋洋");
            sInfo.setSId(9999);
//            执行功能
            Student student = studentMapper.findSelfInfoBySnameAndSid(sInfo);

//            查询结果
            System.out.println(student);
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

    //    测试检测学生是否存在
    @Test
    public void testCheckStudent() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student sInfo = new Student();
            sInfo.setSId(9999);
            sInfo.setSName("李洋洋");
//            执行功能
            Student student = studentMapper.checkStudent(sInfo);
            System.out.println("student values:" + student);
//            查询结果
            if (student == null) {
                System.out.println("信息不存在");
            } else {
                System.out.println("信息存在");
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

//    更新学生信息

    /**
     * 更新信息需要id和姓名同时正确才能修改，避免修改到同名学生信息
     */
    @Test
    public void testUpdateStudentByStudentClass() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {

//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student sUpdate = new Student();
            sUpdate.setSTel("13147107758");
            sUpdate.setSName("李洋洋");
            sUpdate.setSId(9999);
            sUpdate.setSGid(4);
//            执行功能
//            查询学生是否存在
            Student checkStudent = studentMapper.checkStudent(sUpdate);
//            查询结果
            if (checkStudent == null) {
                System.out.println("查不到该学生,无法完成修改");
            } else {
                System.out.println("查询到该学生,请按如下信息填写");
                if (studentMapper.updateStudentByStudentClass(sUpdate) > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
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

    //    删除学生信息
    @Test
    public void testDelStudentBySname() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student sDel = new Student();
            sDel.setSId(9);
            sDel.setSName("杨逵");
//            执行功能
            Student checkStudent = studentMapper.checkStudent(sDel);
            if (checkStudent != null) {
                System.out.println("查询成功，可以删除!!!");
                if (studentMapper.delStudentBySNameAndSId(sDel) > 0) {
                    System.out.println("删除成功!!!");
                } else {
                    System.out.println("删除失败!!!");
                }
            } else {
                System.out.println("查询失败，不允许删除!!!");
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

    //   添加学生信息
    @Test
    public void testAddStudentByGrade() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student studentCheck = new Student();
            studentCheck.setSName("李洋洋");
            studentCheck.setSId(9999);
            studentCheck.setSTel("20001");
            studentCheck.setSGid(1);
//            执行功能
//            检查学生是否存在
            Student checkStudent = studentMapper.checkStudent(studentCheck);
//            查询结果
            if (checkStudent != null) {
                System.out.println("数据库中有该学生，不允许添加!!!");
            } else {
                System.out.println("数据库中查不到该学生，可以添加!!!");
//                执行功能
                if (studentMapper.addStudentByGrade(studentCheck)>0){
                    System.out.println("添加成功!!!");
                }else {
                    System.out.println("添加失败!!!");
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
}
