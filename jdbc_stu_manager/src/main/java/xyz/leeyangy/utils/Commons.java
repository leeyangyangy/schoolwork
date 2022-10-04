package xyz.leeyangy.utils;

import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.service.Impl.AdminImpl;
import xyz.leeyangy.service.Impl.StudentImpl;

import java.util.Scanner;

/**
 * @Package: xyz.leeyangy.utils
 * @Author: LEEYANGYANG
 * @Create: 2022/10/4 2:52
 * @Description:
 */
public class Commons {
    //            显示菜单
    Display display = new Display();
    Scanner sc = new Scanner(System.in);
    //    获取选择
    int chooce;
    //    学生菜单
    void student_menu(Student s, boolean flag) {
//            new对象，调用方法
        StudentImpl stuModule = new StudentImpl();
        while (flag) {
            display.Display_Stu();
            chooce = sc.nextInt();
//            chooce = 4;
            switch (chooce) {
                case 1:
                    stuModule.findMyClassInfo(s);
                    break;
                case 2:
                    stuModule.findSelfInfo(s);
                    break;
                case 3:
                    stuModule.findSelfInfo(s);
                    break;
                case 4:
                    stuModule.updateMyInfo(s);
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    //    管理员菜单
    void admin_menu(Student s, boolean flag) {
        AdminImpl adminModule = new AdminImpl();
        while (flag) {
            display.Display_Admin();
            chooce = sc.nextInt();
//            chooce = 9;
            switch (chooce) {
                case 1:
                    adminModule.findAllStudentByGName();
//                    flag = false;
                    break;
                case 2:
                    adminModule.delGrade();
//                    flag = false;
                    break;
                case 3:
                    adminModule.findAllStudentBySubject();
//                    flag = false;
                    break;
                case 4:
                    adminModule.delSubject();
//                    flag = false;
                    break;
                case 5:
                    adminModule.addGrade();
//                    flag = false;
                    break;
                case 6:
                    adminModule.addSubject();
//                    flag = false;
                    break;
                case 7:
                    adminModule.addStudent();
//                    flag = false;
                    break;
                case 8:
                    adminModule.delStudentBySName();
//                    flag = false;
                    break;
                case 9:
                    adminModule.updateStudentInfoBySNameAndSId(s);
//                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

//    主入口菜单
    public void main_menu(){
        //        new对象
        Student s=new Student();
        //    读入信息
        Scanner scId = new Scanner(System.in);
        Scanner scSName = new Scanner(System.in);
        Integer sId = 0;
        String sName;
        Display display = new Display();
        Login login=new Login();
//        login.login();
//        项目入口主程序
        display.Display_Menu();
        int sw;
        Scanner scSw=new Scanner(System.in);
//        获取选择选项
        sw=scSw.nextInt();
        switch (sw){
            case 1:
                System.out.println("请输入登录学生id:");
                sId=scId.nextInt();
//                sId=9999;
                System.out.println("请输入登录学生姓名:");
                sName=scSName.nextLine();
//                sName="李洋洋";
                s.setSId(sId);
                s.setSName(sName);
                System.out.println();
                login.login(s);
            default:
                break;
        }
        System.out.println("管理系统已退出!!!感谢使用!!!");
    }
}
