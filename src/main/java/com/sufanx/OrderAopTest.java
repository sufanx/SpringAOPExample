package com.sufanx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.service.IPointcutService;

public class OrderAopTest {
    
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/order.xml");
        IPointcutService testService = ctx.getBean("pointcutService", IPointcutService.class);
        testService.test();
    }
}
