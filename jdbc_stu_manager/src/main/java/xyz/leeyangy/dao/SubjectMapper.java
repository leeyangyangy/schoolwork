package xyz.leeyangy.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.leeyangy.pojo.Subject;

/**
 * @Package: xyz.leeyangy.dao
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:49
 * @Description:
 */
public interface SubjectMapper {

    /**
     * 添加课程
     * @param
     * @return
     */
    @Insert("INSERT INTO t_subject (subname) VALUES (#{subName})")
    int addSubject(String subName);

    @Select("select sub.subname from t_subject sub where sub.subname=#{subName}")
    Subject checkSubject(String subName);

    @Delete("DELETE from t_subject WHERE t_subject.subname=#{subName}")
    int delSubject(String subName);

    /**
     * 查询指定课程下的所有学生信息
     * 课程和学生对应多对多关系
     * 一个课程可以对应多个学生  已做
     * 一个学生可以对应多个选课  已做
     *
     * @param subName
     * @return
     */
    Subject findAllStudentBySubject(String subName);
}
