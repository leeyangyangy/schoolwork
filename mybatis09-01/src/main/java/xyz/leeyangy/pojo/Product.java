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
public class Product {
    private Integer pid;
    private String pname;
    private double price;
//    商品与订单一对多关系
//    private List<TOrder> orderList;
}
