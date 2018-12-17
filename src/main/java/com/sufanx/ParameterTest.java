package com.sufanx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.quickstart.service.QuickStartService;
import com.sufanx.service.IPointcutService;

public class ParameterTest {
    
    @Test
    public void test() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter6/parameter.xml");
        QuickStartService helloService = ctx.getBean("helloWorldService", QuickStartService.class);
        IPointcutService pointcutService = ctx.getBean("pointcutService", IPointcutService.class);
        //使用JoinPoint获取参数
        helloService.before("parameter");
        System.out.println("======================================");

        //自动获取
        pointcutService.test("parameter");
        System.out.println("======================================");
       
    }
    
    
}
