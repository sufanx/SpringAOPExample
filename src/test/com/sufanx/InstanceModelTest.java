package com.sufanx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.service.PointcutService;

public class InstanceModelTest {
    
    
    @Test
    public void test() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("instanceModel.xml");
        PointcutService testService1 = ctx.getBean("pointcutService1", PointcutService.class);

        PointcutService testService2 = ctx.getBean("pointcutService2", PointcutService.class);

        testService1.test();
        System.out.println("======================================");
        testService2.test();
        System.out.println("======================================");
    }
    
    
}
