package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/9/30 23:11
 * @Description:
 */
@Data
public class TOrder {
    private Integer oid;
    private String status;
    private Double totalPrice;
    private Integer cid;
    private Date createTime;
//    一个订单对应多个商品
    private List<Product> productList;
}
