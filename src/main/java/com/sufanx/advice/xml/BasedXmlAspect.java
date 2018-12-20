package com.sufanx.advice.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;

public class BasedXmlAspect {

    /**
     * 前置通知
     */
    public void beforeAdvice() {
        System.out.println("> before advice：有用户正在尝试登录");
    }


    /**
     * 可参考 {@link AfterReturningAdvice} 中的注释
     * <p>
     * TODO 可能存在的问题：
     * 1. 此处是否会对返回结果产生影响（直接改变返回值，改变返回值数据）
     * 对返回值可见，但是不可改变它(能修改返回对象中的数据，不能改变为其它的对象)
     * 2. 如果抛出异常会导致什么
     * 将异常包装为运行时异常，返回给方法的调用者
     *
     * @param retVal (多态)基本类型->自动装箱
     * @see AfterReturningAdvice
     */
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

    /**
     * 可参考 {@link ThrowsAdvice} 中的注释
     * <p>
     * TODO 可能存在的问题：
     * 1. 如果抛出异常会导致什么
     * 把原始异常覆盖掉
     *
     * @param exception
     * @see ThrowsAdvice
     */
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("> after throwing advice：┗|｀O′|┛ 嗷~~,登录过程出现异常啦，" + exception.getMessage());
//        throw new RuntimeException("再抛出一个异常试试");
    }

    /**
     * 后置最终通知
     */
    public void afterFinallyAdvice() {
        System.out.println("> after finally advice：登录过程结束");
    }

    /**
     * TODO 可能存在的问题：
     * 1. 如果抛出异常会导致什么
     * 等同于目标方法抛出异常
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
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
