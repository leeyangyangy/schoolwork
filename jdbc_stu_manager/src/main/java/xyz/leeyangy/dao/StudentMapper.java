package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.leeyangy.pojo.Grade;
import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.pojo.Subject;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:49
 * @Description:
 */
public interface StudentMapper {

    /**
     * 登录入口
     * 通过学生id和手机号登录
     * 使用注解Select传参
     * 返回一个对象，通过对象中取值判断是否管理员
     *
     * @param student
     * @return
     */
    @Select("SELECT * from t_student WHERE sid=#{sId} and sName=#{sName}")
    Student Login(Student student);

    /**
     * 管理员
     * 在指定班级下添加学生
     *
     * @param student
     * @return
     */
    @Insert("INSERT INTO t_student (sname,stel,sgid) VALUES (#{sName},#{sTel},#{sGid})")
    int addStudentByGrade(Student student);


    /**
     * 管理员
     * 查询指定班级下的所有学生信息
     *
     * @param grade
     * @return
     */
    Grade findGradeStudent(Integer grade);

    /**
     * 管理员
     * 查询学习了指定课程下的所有学生信息
     * @param sName
     * @return
     */
//    Subject findAllStudentBySubject(String sName);

    /**
     * 管理员
     * 删除指定学生
     *
     * @param student
     * @return
     */
    @Delete("DELETE from t_student WHERE t_student.sname=#{sName} and t_student.sid=#{sId} ")
    int delStudentBySNameAndSId(Student student);

    /**
     * 管理员和学生共用代码
     * 修改指定学生信息 和 修改该学生的个人信息
     * 只更改个人，不更新选课
     *
     * @param student
     * @return
     */

    int updateStudentByStudentClass(Student student);

    /**
     * 学生
     * 查询该学生自己的所有学生信息
     *
     * @param
     */
//    @Select("SELECT s.sid,s.sname,s.stel,s.sgid FROM t_student s WHERE s.sname=#{sname} and s.sid=#{sid}")
    Student findSelfInfoBySnameAndSid(Student student);


    /**
     * 检查数据库是否存在数据
     *
     * @param student
     * @return
     */
    @Select("SELECT s.sid,s.sname FROM t_student s WHERE s.sid = #{sId} AND s.sname = #{sName}")
    Student checkStudent(Student student);

}
