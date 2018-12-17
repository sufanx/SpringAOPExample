package com.sufanx.quickstart.javaconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.sufanx.service.IIntroductionService;

/**
 * @author shuyufan
 */
@Aspect
public class QuickStart {

    @Pointcut(value = "execution(* com.sufanx..*.sayBefore(java.lang.String)) && args(param)", argNames = "param")
    public void beforePointcut(String param) {
    }

    @Before(value = "beforePointcut(param)", argNames = "param")
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

    @AfterReturning(
            value = "execution(* com.sufanx..*.sayBefore(..))",
            pointcut = "execution(* com.sufanx..*.sayAfterReturning(..))",
            argNames = "retVal", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("===========after returning advice retVal:" + retVal);
    }

    @AfterThrowing(
            value = "execution(* com.sufanx..*.sayAfterThrowing(..))",
            argNames = "exception", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("===========after throwing advice exception:" + exception);
    }

    @After(value = "execution(* com.sufanx..*.sayAfterFinally(..))")
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }

    @Around(value = "execution(* com.sufanx..*.sayAround(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========around before advice");
        Object retVal = pjp.proceed(new Object[]{"replace"});
        System.out.println("===========around after advice");
        return retVal;
    }

    @DeclareParents(value = "com.sufanx..*.IHelloWorldService+", defaultImpl = com.sufanx.service.impl.IntroductiondService.class)
    private IIntroductionService introductionService;

    @Around(value = "this(com.sufanx.service.IIntroductionService+)")
    public Object thisPointcut(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========around sssss advice");
        Object retVal = pjp.proceed();
        System.out.println("===========around ssss advice");
        return retVal;
    }
}
