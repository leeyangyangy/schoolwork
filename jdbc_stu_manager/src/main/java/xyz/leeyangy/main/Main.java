package xyz.leeyangy.main;

import xyz.leeyangy.service.Impl.AdminImpl;

/**
 * @Package: xyz.leeyangy.main
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:48
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
//        Display display = new Display();
//        Login login=new Login();
////        login.login();
////        项目入口主程序
//        display.Display_Menu();
//        int sw=2;
//        Scanner scSw=new Scanner(System.in);
////        获取选择选项
////        sw=scSw.nextInt();
//        switch (sw){
//            case 1:
//                login.login();
//            default:
//                break;
//        }

        AdminImpl admin = new AdminImpl();
//        admin.delGrade();
//        admin.addGrade();
//            admin.addSubject();
//            admin.delSubject();
        admin.findAllStudentBySubject();
        admin.findAllStudentByGName();


        System.out.println("管理系统已退出!!!感谢使用!!!");
    }
}
