package xyz.leeyangy;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.leeyangy.config.SpringConfig;
import xyz.leeyangy.dao.AccountDao;
import xyz.leeyangy.domain.Account;
import xyz.leeyangy.service.AccountService;
import xyz.leeyangy.utils.MybatisUtils;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class FunctionTest {
//    @Test
//    public void testFindAll() {
////        1.创建SqlSession对象
//        SqlSession session = null;
//        try {
////           获取session
//            session = MybatisUtils.getSqlSession();
////            获取接口对象
//            AccountDao accountDao = session.getMapper(AccountDao.class);
////            执行功能
//            List<Account> list = accountDao.findAll();
////            查询结果
//            for (Account account:list){
//                System.out.println(list);
//            }
////            提交事务
//            session.commit();
//        } catch (Exception e) {
////                事务回滚
//            session.rollback();
//            e.printStackTrace();
//        } finally {
////                关闭session
//            MybatisUtils.close(session);
//        }
//    }
    @Test
    public void testSqlSessionFactoryBean(){
//        获取ioc容器
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }

}

