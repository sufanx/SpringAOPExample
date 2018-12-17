package com.sufanx.quickstart.xml;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.quickstart.service.LoginService;
import com.sufanx.quickstart.service.QuickStartService;
import com.sufanx.service.IIntroductionService;

/**
 * 如果需要单独测试某个Advice，在quickStart.xml中把其它Advice注释掉
 */
public class QuickStartTest {

    @Test
    public void quickStart() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("quickStart.xml");
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("quickStart.xml");
        LoginService loginService = ctx.getBean("loginService", LoginService.class);

        loginService.login("", "");
    }

    @Test
    public void introduction() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("quickStart.xml");
        IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("======================================");
    }

    @Test
    public void advisor() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("quickStart.xml");
        QuickStartService helloworldService = ctx.getBean("helloWorldService", QuickStartService.class);
        helloworldService.sayAdvisorBefore("haha");
        System.out.println("======================================");
    }
}
