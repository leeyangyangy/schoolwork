package xyz.leeyangy.service.Impl;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.pojo.Subject;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 16:58
 * @Description:
 */
public class StudentImpl {
    /**
     * 查询我的班级信息
     */


    /**
     * 学生查询自己的信息
     * 需要重新写用户信息
     * /**
     * * 查询我学习的课程
     */
    @Test
    public void findSelfInfo() {
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
            System.out.println("学生信息: id:" + student.getSId() + " 姓名:" +
                    student.getSName() + " 班级:" + student.getSGid() + "班 " +
                    "\n我的选课:"
            );
            List<Subject> list = student.getSubjectList();
            for (Subject subject : list) {
                System.out.println(subject.getSubName());
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

    /**
     * 修改我的信息
     */
    public void updateMyInfo() {
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
}
