package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.leeyangy.pojo.Grade;
import xyz.leeyangy.pojo.Student;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:49
 * @Description:
 */
public interface GradeMapper {

    /**
     * 插入数据之前，先对数据库中数据进行查找，是否存在
     */
//    @Select("select g.gname from t_grade g where g.gname=#{gname}")
//    Grade findGradeByGname(String gname);
//    替换上面接口
    @Select("select g.gname from t_grade g where g.gname=#{gName}")
    Grade checkGradeInfo(String gName);

    /**
     * 管理员
     * 添加班级，单表操作
     *
     * @param
     * @return
     */
    @Insert("INSERT into t_grade (gname) VALUE (#{gName})")
    int addGrade(String gName);

    /**
     * 删除班级前先查询班级是否存在
     */
//    @Select("select ")
//    Grade findByGrade(Integer grade);

    /**
     * 管理员
     * 删除指定班级，以及该班级下所有学生
     *
     * @param gName
     * @return
     */
    @Delete("DELETE FROM  t_grade WHERE gname = #{gName}")
    int delAllStudentByGrade(String gName);

    /**
     * 管理员
     * 查询该班级下的所有学生
     *
     * @param gName
     * @return
     */
    Grade findAllStudentByGname(String gName);

    /**
     * 管理员和学生 操作 共用代码
     * 查询该学生选择学习的课程
     */

    Grade findMyGradeInfo(Student student);
}
