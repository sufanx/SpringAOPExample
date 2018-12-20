package com.sufanx.advice.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.sufanx.service.LogoutService;
import com.sufanx.service.impl.LogoutServiceImpl;

/**
 * @author shuyufan
 */
@Aspect
public class BasedAspectjAspect {

    @DeclareParents(value = "com.sufanx..*.LoginService+", defaultImpl = LogoutServiceImpl.class)
    private LogoutService logoutService;

    @Pointcut(value = "execution(* com.sufanx..*.login(..))")
    public void beforePointcut() {
    }

    @Before(value = "beforePointcut()")
    public void beforeAdvice() {
        System.out.println("> before advice：有用户正在尝试登录");
    }

    @AfterReturning(
            value = "execution(* com.sufanx..*.login(..))",
            pointcut = "execution(* com.sufanx..*.login(..))",
            argNames = "retVal", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        String message;
        if ((Boolean) retVal) {
            message = "登录成功";

            // 用于测试抛出异常的情况
            // throw new RuntimeException("就不让你登录成功");
        } else {
            message = "登录失败";
        }
        System.out.println("> after returning advice：提前告诉你哦，" + message);
    }

    @AfterThrowing(
            value = "execution(* com.sufanx..*.login(..))",
            argNames = "exception", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("> after throwing advice：┗|｀O′|┛ 嗷~~,登录过程出现异常啦，" + exception.getMessage());
//        throw new RuntimeException("再抛出一个异常试试");
    }

    @After(value = "execution(* com.sufanx..*.login(..))")
    public void afterFinallyAdvice() {
        System.out.println("> after finally advice：登录过程结束");
    }

    @Around(value = "execution(* com.sufanx..*.login(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("> around before advice：登录过程被劫持啦");

        // 覆盖原始参数
//        System.out.println("覆盖原始参数");
//        Object retVal = joinPoint.proceed(new Object[]{"admin", "123456" });

        Object retVal = joinPoint.proceed();
        if (!(Boolean) retVal) {
            // 异常测试
            throw new RuntimeException("抛出异常会发生什么");
        }
        System.out.println("> around after advice：劫持登录结束");
        return retVal;
    }


}
