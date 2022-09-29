package xyz.leeyangy.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @Package: xyz.leeyangy.utils
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 13:13
 * @Description:
 */
public class IDUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
        System.out.println(IDUtils.getId());
    }
}
