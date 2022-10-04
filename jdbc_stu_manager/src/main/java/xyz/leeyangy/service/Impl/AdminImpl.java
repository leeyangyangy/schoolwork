package xyz.leeyangy.service.Impl;

import org.apache.ibatis.session.SqlSession;
import xyz.leeyangy.dao.GradeMapper;
import xyz.leeyangy.dao.StudentMapper;
import xyz.leeyangy.dao.SubjectMapper;
import xyz.leeyangy.pojo.Grade;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.pojo.Subject;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @Package: xyz.leeyangy.service
 * @Author: LEEYANGYANG
 * @Create: 2022/10/3 16:58
 * @Description:
 */
public class AdminImpl {

    /**
     * 管理员 添加学生班级
     */
    public void addGrade() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
//            从控制台读入数据
            System.out.println("请输入要添加的班级名称(如 一班...五班):");
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

    /**
     * 管理员 添加选课
     */
    public void addSubject() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
            Scanner scSubject = new Scanner(System.in);
            String subName;
            System.out.println("请输入选课:");
            subName = scSubject.nextLine();
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
//                total = ;
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

    /**
     * 管理员 添加学生
     */
    public void addStudent() {
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
                if (studentMapper.addStudentByGrade(studentCheck) > 0) {
                    System.out.println("添加成功!!!");
                } else {
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

    /**
     * 管理员 更新学生信息
     */
    public void updateStudentInfoBySNameAndSId(Student find) {
        Scanner scanner=new Scanner(System.in);
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
            String tel;
            String name;
            Integer gId;
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            System.out.println("请输入要修改信息(不要修改的回车即可):");
//            System.out.println("请输入姓名:");
//            name=scanner.nextLine();
//            find.setSName(name);

            System.out.println("请输入电话:");
            tel=scanner.nextLine();
            find.setSTel(tel);

            System.out.println("请输入班级(1..2...4...n):");
            gId=scanner.nextInt();

//            boolean checkGrade()

//            防止误输入，直接赋值 为 1
            if(gId>=4 ||gId<0){
                gId=1;
            }
            find.setSGid(gId);
//            执行功能
//            查询学生是否存在
            Student checkStudent = studentMapper.checkStudent(find);
//            查询结果
            if (checkStudent == null) {
                System.out.println("查不到该学生,无法完成修改");
            } else {
                System.out.println("查询到该学生,请按如下信息填写");
                if (studentMapper.updateStudentByStudentClass(find) > 0) {
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

    /**
     * 管理员 删除学生班级
     */
    public void delGrade() {
//        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
//            从控制台读入数据
            System.out.println("请输入要删除的班级名称(如 一班...五班):");
            Scanner scGClass = new Scanner(System.in);
            String gClass;
            gClass = scGClass.nextLine();
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

    /**
     * 管理员 删除选课
     */
    public void delSubject() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
            String subName;
            System.out.println("请输入要删除的课程:");
            Scanner scSubName = new Scanner(System.in);
            subName = scSubName.nextLine();
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

    /**
     * 管理员 删除学生  修改添加信息
     */
    public void delStudentBySName() {
        Scanner scanner=new Scanner(System.in);
        Integer id;
        String name;
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student sDel = new Student();
            System.out.println("请输入要删除的学生学号:");
            id=scanner.nextInt();
            sDel.setSId(id);
            System.out.println("请输入要删除的学生姓名:");
            name=scanner.nextLine();
            sDel.setSName(name);
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

    /**
     * 管理员 查询指定选课下的所有学生
     */
    public void findAllStudentBySubject() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
            String subName;
            Scanner scSubName = new Scanner(System.in);
            System.out.println("请输入要查询的选课:");
            subName = scSubName.nextLine();
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
                System.out.println("查询选课成功,查询到学生如下:");
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

    /**
     * 管理员 查询指定班级下所有学生
     */
    public void findAllStudentByGName() {
        //        1.创建SqlSession对象
        SqlSession session = null;
        try {
            Scanner scanner = new Scanner(System.in);
//           获取session
            session = MybatisUtils.getSqlSession();
//            获取接口对象
            GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
            String gName;
            System.out.print("请输入查询班级(一班....二班....四班):");
            gName = scanner.nextLine();
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

}
