package com.sufanx.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class OrderAspectSecond {

    @Pointcut(value = "execution(* *(..))")
    public void pointcut() {
    }

    @Before(value = "pointcut()")
    public void beforeAdviceFirst() {
        System.out.println("SecondAspect：before advice 1");
    }

    @Before(value = "pointcut()")
    public void beforeAdviceSecond() {
        System.out.println("SecondAspect：before advice 2");
    }

    @Around(value = "pointcut()")
    public Object aroundAdviceFirst(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("SecondAspect：around before advice 1");
        Object retVal = pjp.proceed();
        System.out.println("SecondAspect：around after advice 2");
        return retVal;
    }

    @Around(value = "pointcut()")
    public Object aroundAdviceSecond(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("SecondAspect：around before advice 1");
        Object retVal = pjp.proceed();
        System.out.println("SecondAspect：around after advice 2");
        return retVal;
    }

    @AfterReturning(value = "pointcut()", argNames = "retVal", returning = "retVal")
    public void afterReturningAdviceFirst(Object retVal) {
        System.out.println("SecondAspect：after returning advice 1");
    }

    @AfterReturning(value = "pointcut()", argNames = "retVal", returning = "retVal")
    public void afterReturningAdviceSecond(Object retVal) {
        System.out.println("SecondAspect：after returning advice 2");
    }

    @AfterThrowing(value = "pointcut()", argNames = "retVal", throwing = "retVal")
    public void afterThrowingAdviceFirst(Exception exception) {
        System.out.println("SecondAspect：after throwing advice 1");
    }

    @AfterThrowing(value = "pointcut()", argNames = "retVal", throwing = "retVal")
    public void afterThrowingAdviceSecond(Exception exception) {
        System.out.println("SecondAspect：after throwing advice 2");
    }

    @After(value = "pointcut()")
    public void afterFinallyAdviceFirst() {
        System.out.println("SecondAspect：after finally advice 1");
    }

    @After(value = "pointcut()")
    public void afterFinallyAdviceSecond() {
        System.out.println("SecondAspect：after finally advice 2");
    }


}
