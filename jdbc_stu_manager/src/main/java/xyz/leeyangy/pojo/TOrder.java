package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/9/27 15:13
 * @Description:
 */
@Data
public class TOrder {
    private Integer oid;
    private String status;
    private Double totalPrice;
    private Integer cid;
    private Date createTime;
//    一对多
    private Customer customer;
//
//    public Integer getOid() {
//        return oid;
//    }
//
//    public void setOid(Integer oid) {
//        this.oid = oid;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(Double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    public Integer getCid() {
//        return cid;
//    }
//
//    public void setCid(Integer cid) {
//        this.cid = cid;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @Override
//    public String toString() {
//        return "TOrderMapper{" +
//                "oid=" + oid +
//                ", status='" + status + '\'' +
//                ", totalPrice=" + totalPrice +
//                ", cid=" + cid +
//                ", createTime=" + createTime +
//                ", customer=" + customer +
//                '}';
//    }
}
