package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.leeyangy.config.SpringConfig;
import xyz.leeyangy.domain.Account;
import xyz.leeyangy.service.AccountService;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class FunctionTest {
    @Test
    public void testSqlSessionFactoryBean(){
//        获取ioc容器
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }

}

