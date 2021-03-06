package com.sufanx.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ReferencePointcutAspect {
    
    @Pointcut(value="execution(* *(..))")
    public void pointcut() {}
    
}
