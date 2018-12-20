package com.sufanx;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.service.LoginService;
import com.sufanx.service.LogoutService;

/**
 * 如果需要单独测试某个Advice，在quickStart.xml中把其它Advice注释掉
 */
public class QuickStartTest {

    private String config = "basedXml.xml";
//    private String config = "basedAspectj.xml";

    @Test
    public void quickStart() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        LoginService loginService = ctx.getBean("loginService", LoginService.class);
        boolean success = loginService.login("admin", "123456");
        if (success) {
            System.out.println("  登录成功");
        } else {
            System.out.println("  登录失败");
        }
    }

    @Test
    public void afterThrowingAdviceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        LoginService loginService = ctx.getBean("loginService", LoginService.class);
        loginService.login("", "");
    }

    @Test
    public void introduction() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 注意 BeanName ,是 LoginService,其并没有真正的实现 LogoutService 接口
        LogoutService loginService = ctx.getBean("loginService", LogoutService.class);
        loginService.logout();
    }
}