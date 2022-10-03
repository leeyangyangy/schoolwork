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
public class Subject {
    private Integer subId;
    private String subName;
    //    一个课程对应多个学生
    private List<Student> studentList;
}
