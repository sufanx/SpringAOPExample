package com.sufanx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.parameter.ParameterService;
import com.sufanx.service.QuickStartService;
import com.sufanx.service.PointcutService;

public class ParameterTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("parameter.xml");
        ParameterService parameterService = ctx.getBean("parameterService", ParameterService.class);
        parameterService.injectForJointPoint("parameter");

//        QuickStartService helloService = ctx.getBean("helloWorldService", QuickStartService.class);
//        PointcutServiceImpl pointcutService = ctx.getBean("pointcutService", PointcutServiceImpl.class);
//        //使用JoinPoint获取参数
//        helloService.sayBefore("parameter");
//        //自动获取
//        pointcutService.test("parameter");

    }


}
