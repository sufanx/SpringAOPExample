package com.sufanx.order;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author shuyufan
 */
public class OrderAspectFirst {

    public void beforeAdviceFirst() {
        System.out.println("FirstAspect：before advice 1");
    }

    public void beforeAdviceSecond() {
        System.out.println("FirstAspect：before advice 2");
    }

    public void afterFinallyAdviceFirst() {
        System.out.println("FirstAspect：after finally advice 1");
    }

    public void afterFinallyAdviceSecond() {
        System.out.println("FirstAspect：after finally advice 2");
    }

    public void afterReturningAdviceFirst(Object retVal) {
        System.out.println("FirstAspect：after returning advice 1");
    }

    public void afterReturningAdviceSecond(Object retVal) {
        System.out.println("FirstAspect：after returning advice 2");
    }

    public void afterThrowingAdviceFirst(Exception exception) {
        System.out.println("FirstAspect：after throwing advice 1");
    }

    public void afterThrowingAdviceSecond(Exception exception) {
        System.out.println("FirstAspect：after throwing advice 2");
    }

    public Object aroundAdviceFirst(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("FirstAspect：around before advice 1");
        Object retVal = pjp.proceed();
        System.out.println("FirstAspect：around after advice 1");
        return retVal;
    }

    public Object aroundAdviceSecond(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("FirstAspect：around before advice 2");
        Object retVal = pjp.proceed();
        System.out.println("FirstAspect：around after advice 2");
        return retVal;
    }

}
