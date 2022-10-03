package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:48
 * @Description:
 */
@Data
public class Student {
    //    学生id
    private Integer sId;
    //    学生姓名
    private String sName;
    //    学生电话号码
    private String sTel;
    //    学生班级
    private Integer sGid;
    //    是否管理员
    private Integer isAdmin;
    //    学生和选课之间是一对多关系
    private List<Subject> subjectList;
}
