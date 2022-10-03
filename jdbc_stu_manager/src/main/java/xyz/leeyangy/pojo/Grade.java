package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:49
 * @Description:
 */
@Data
public class Grade {
    //    班级id
    private Integer gId;
    //    班级名
    private String gName;
    //    一个班级多个学生
    private List<Student> studentList;
}
