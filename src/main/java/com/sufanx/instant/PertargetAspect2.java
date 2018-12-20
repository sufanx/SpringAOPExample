package com.sufanx.instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import com.sufanx.service.LogoutService;
import com.sufanx.service.impl.LogoutServiceImpl;

@Aspect("pertarget(target(com.sufanx.service.PointcutServiceImpl))")
public class PertargetAspect2 {
   
    private int counter = 1;
    

    @DeclareParents(value = "cn.javass..IPointcutService+", defaultImpl = LogoutServiceImpl.class)
    private LogoutService introductionService;
    
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        System.out.println("============pertarget(target(com.sufanx.service.PointcutServiceImpl)):" + counter++);
    }
    
}
