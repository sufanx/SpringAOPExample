package com.sufanx.instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import com.sufanx.service.LogoutService;
import com.sufanx.service.impl.LogoutServiceImpl;

@Aspect("perthis(this(com.sufanx.service.LogoutService))")
public class PerthisAspect {
   
    private int counter = 1;
    
    @DeclareParents(value = "cn.javass..IPointcutService+", defaultImpl = LogoutServiceImpl.class)
    private LogoutService introductionService;
    
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        System.out.println("============perthis(this(com.sufanx.service.LogoutService)):" + counter++);
    }
    
}
