package com.sufanx.instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect()
public class SingletonAspect {
   
    private int counter = 1;
    
    
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        System.out.println("============singleton:" + counter++);
    }
    
}
