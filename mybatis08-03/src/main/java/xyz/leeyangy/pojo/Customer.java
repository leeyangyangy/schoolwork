package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:10
 * @Description:
 */
@Data
public class Customer {
    private Integer cid;
    private String cname;
    private String telephone;
    private String password;
    private List<TOrder> orderList;
}