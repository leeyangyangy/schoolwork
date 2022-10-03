package xyz.leeyangy.utils;

/**
 * @Package: xyz.leeyangy.utils
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:50
 * @Description:
 */
public class Display {
    public void Display_Menu() {
        System.out.println("------------学生信息管理------------");
        System.out.println("1.登录    2.退出");
        System.out.println("----------------------------------");

    }

    public void Display_Stu() {
        System.out.println("------------学生面板------------");
        System.out.println("1.查询我的班级信息");
        System.out.println("2.查询我的信息");
        System.out.println("3.查询我学习的课程");
        System.out.println("4.修改我的信息");
        System.out.println("0.任意键退出");
        System.out.println("------------------------------");
    }

    public void Display_Admin() {
        System.out.println("------------管理员面板------------");
        System.out.println("1.查询指定班级下所有学生信息");
        System.out.println("2.删除指定班级，以及该班级下所有学生");
        System.out.println("3.查询学习了指定课程下的所有学生信息");
        System.out.println("4.删除指定课程，但是不删除学生信息 ");
        System.out.println("5.添加班级");
        System.out.println("6.添加课程");
        System.out.println("7.在指定班级下添加学生");
        System.out.println("8.删除指定学生");
        System.out.println("9.修改指定学生信息");
        System.out.println("0.任意键退出");
        System.out.println("--------------------------------");
    }
}
