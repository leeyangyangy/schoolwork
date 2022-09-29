package xyz.leeyangy.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Package: xyz.leeyangy.pojo
 * @Author: LEEYANGYANG
 * @Create: 2022/9/27 15:13
 * @Description:
 */
@Data
public class Customer {
    private Integer cid;
    private String cname;
    private String telephone;
    private String password;
    private List<TOrder> orders;
//    public Integer getCid() {
//        return cid;
//    }
//
//    public void setCid(Integer cid) {
//        this.cid = cid;
//    }
//
//    public String getCname() {
//        return cname;
//    }
//
//    public void setCname(String cname) {
//        this.cname = cname;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "cid=" + cid +
//                ", cname='" + cname + '\'' +
//                ", telephone='" + telephone + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
