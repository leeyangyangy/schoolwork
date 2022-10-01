package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/9/26 18:06
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private Date birthday;
}
