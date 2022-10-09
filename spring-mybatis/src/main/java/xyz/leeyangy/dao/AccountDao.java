package xyz.leeyangy.dao.impl;

import xyz.leeyangy.domain.Account;

/**
 * @Package: xyz.leeyangy.dao.impl
 * @Author: LEEYANGYANG
 * @Create: 2022/10/10 0:20
 * @Description:
 */
public interface AccountDao {
//    通过id查找用户
    Account findUserById(Integer ids);
}
