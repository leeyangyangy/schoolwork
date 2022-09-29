package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:10
 * @Description:
 */
@Data
public class TOrder {
    private Integer oid;
    private String status;
    private Double totalPrice;
    private Integer cid;
    private Date createTime;
//    订单与顾客一对一关系
    private Customer customer;
//    订单与商品一对多关系
    private List<Product> productList;

}

