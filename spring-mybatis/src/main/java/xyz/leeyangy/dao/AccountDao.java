package xyz.leeyangy.dao.impl;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.leeyangy.domain.Account;

import java.util.List;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 0:20
 * @Description:
 */
public interface AccountDao {
//    通过id查找用户
    @Select("SELECT * from t_account WHERE id=#{ids}")
    Account findUserById(Integer ids);

//    查找所有用户
    @Select("select * from t_account")
    List<Account> findAll();

//    删除用户
    @Delete("delete from t_account where id=#{ids}")
    int delateUserById(Integer ids);

//    新增用户
    @Insert("")
    int addUser(Account account);

}
