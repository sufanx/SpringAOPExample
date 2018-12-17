package com.sufanx.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import com.sufanx.service.IIntroductionService;

@Aspect("perthis(this(com.sufanx.service.IIntroductionService))")
public class PerthisAspect {
   
    private int counter = 1;
    
    @DeclareParents(value = "cn.javass..IPointcutService+", defaultImpl = com.sufanx.service.impl.IntroductiondService.class)
    private IIntroductionService introductionService;
    
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        System.out.println("============perthis(this(com.sufanx.service.IIntroductionService)):" + counter++);
    }
    
}
