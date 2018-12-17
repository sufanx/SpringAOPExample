package com.sufanx.quickstart.javaconfig;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.quickstart.service.QuickStartService;
import com.sufanx.service.IIntroductionService;
import com.sufanx.service.IPayService;

public class QuickStartTest {


    @Test
    public void testAnnotationBeforeAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice2.xml");
        QuickStartService helloworldService = ctx.getBean("helloWorldService", QuickStartService.class);
        helloworldService.before("before");
        System.out.println("======================================");
    }

    @Test
    public void testAnnotationAfterReturningAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice2.xml");
        QuickStartService helloworldService = ctx.getBean("helloWorldService", QuickStartService.class);
        helloworldService.sayAfterReturning();
        System.out.println("======================================");
    }

    @Test(expected = RuntimeException.class)
    public void testAnnotationAfterThrowingAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice2.xml");
        QuickStartService helloworldService = ctx.getBean("helloWorldService", QuickStartService.class);
        helloworldService.sayAfterThrowing();
        System.out.println("======================================");
    }

    @Test(expected = RuntimeException.class)
    public void testAnnotationAfterFinallyAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice2.xml");
        QuickStartService helloworldService = ctx.getBean("helloWorldService", QuickStartService.class);
        helloworldService.sayAfterFinally();
        System.out.println("======================================");
    }

    @Test
    public void testAnnotationAroundAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice2.xml");
        QuickStartService helloworldService = ctx.getBean("helloWorldService", QuickStartService.class);
        helloworldService.sayAround("haha");
        System.out.println("======================================");
    }

    @Test
    public void testAnnotationIntroduction() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/advice2.xml");
        IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("======================================");
    }


    @Test
    public void testSchema() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/schemeAop.xml");
        IPayService payService = ctx.getBean("pointPayService", IPayService.class);
        payService.pay(1, 1);
    }
}


