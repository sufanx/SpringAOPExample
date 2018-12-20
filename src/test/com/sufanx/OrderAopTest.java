package com.sufanx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.service.LoginService;

public class OrderAopTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("order.xml");
        LoginService loginService = ctx.getBean("loginService", LoginService.class);
        boolean success = loginService.login("admin", "123456");
        if (success) {
            System.out.println("  登录成功");
        } else {
            System.out.println("  登录失败");
        }
    }
}
