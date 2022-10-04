package xyz.leeyangy.main;

import xyz.leeyangy.pojo.Student;
import xyz.leeyangy.service.Impl.AdminImpl;
import xyz.leeyangy.utils.Commons;
import xyz.leeyangy.utils.Display;
import xyz.leeyangy.utils.Login;

import java.util.Scanner;

/**
 * @Package: xyz.leeyangy.main
 * @Author: LEEYANGYANG
 * @Create: 2022/10/2 21:48
 * @Description: 主程序入口
 */
public class Main {
    public static void main(String[] args) {
        Commons commons=new Commons();
        commons.main_menu();
    }
}
