package com.sufanx.pointcut;

import org.aspectj.lang.JoinPoint;
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
public class PointcutAspect {

    /*
     * Execution Start
     */

    /**
     * 匹配任何方法
     */
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        print("execution(public * *(..)", jp);
    }

    /**
     * com.sufanx包下及其所有子包下的IPointcutService接口中所有的空参方法
     */
    @Before(value = "execution(* com.sufanx..IPointcutService.*())")
    public void executionTest2(JoinPoint jp) {
        print("execution(* com.sufanx..PointcutServiceImpl.*())", jp);
    }

    /**
     * com.sufanx包下及其子包下任何类的所有方法
     */
    @Before(value = "execution(* com.sufanx..*.*(..))")
    public void executionTest3(JoinPoint jp) {
        print("execution(* com.sufanx..*.*(..))", jp);
    }

    /**
     * com.sufanx包下及其所有子包下的IPointcutService接口中具有一个任意类型参数的所有方法
     */
    @Before(value = "execution(* com.sufanx..IPointcutService.*(*))")
    public void executionTest4(JoinPoint jp) {
        print("execution(* com.sufanx..PointcutServiceImpl.*(*))", jp);
    }

    /**
     * 非com.sufanx包下及所有子包下IPointcutService接口及子类型的任何方法
     */
    @Before(value = "execution(* (!com.sufanx..IPointcutService+).*(..))")
    public void executionTest5(JoinPoint jp) {
        //如果!com.sufanx..IPointcutService+ 不加“+”将匹配不到
        print("execution(* (!com.sufanx..IPointcutService+).*(..))", jp);
    }

    /**
     * com.sufanx包下及其所有子包下的IPointcutService接口及其子类型中所有的空参方法
     */
    @Before(value = "execution(* com.sufanx..IPointcutService+.*())")
    public void executionTest6(JoinPoint jp) {
        print("execution(* com.sufanx..PointcutServiceImpl+.*())", jp);
    }


    @Before(value = "execution(* com.sufanx..IPointcut*.test*(java.util.Date))")
    public void executionTest7(JoinPoint jp) {
        print("execution(* com.sufanx..IPointcut*.test*(java.util.Date))", jp);
    }

    @Before(value = "execution(* com.sufanx..IPointcut*.test*(..) throws IllegalArgumentException, ArrayIndexOutOfBoundsException)")
    public void executionTest8(JoinPoint jp) {
        print("execution(* com.sufanx..IPointcut*.test*(..)  throws IllegalArgumentException, ArrayIndexOutOfBoundsException)", jp);
    }

    @Before(value = "execution(* (com.sufanx..IPointcutService+ && java.io.Serializable+).*(..))")
    public void executionTest9(JoinPoint jp) {
        print("execution(* (com.sufanx..PointcutServiceImpl+ && java.io.Serializable+).*(..))", jp);
    }

    /**
     * 返回类型持有 @java.lang.Deprecated
     */
    @Before(value = "execution(@java.lang.Deprecated * *(..))")
    public void executionTest10(JoinPoint jp) {
        print("execution(@java.lang.Deprecated * *(..))", jp);
    }

    /**
     * 返回类型持有 @java.lang.Deprecated 和 @com.sufanx..Secure
     */
    @Before(value = "execution(@java.lang.Deprecated @com.sufanx..Secure * *(..))")
    public void executionTest11(JoinPoint jp) {
        print("execution(@java.lang.Deprecated @com.sufanx..Secure * *(..))", jp);
    }

    /**
     * 返回类型持有 @java.lang.Deprecated 或 @com.sufanx..Secure
     */
    @Before(value = "execution(@(java.lang.Deprecated || com.sufanx..Secure) * *(..))")
    public void executionTest12(JoinPoint jp) {
        print("execution(@(java.lang.Deprecated || com.sufanx..Secure) * *(..))", jp);
    }

    @Before(value = "execution((@com.sufanx..Secure *) *(..))")
    public void executionTest13(JoinPoint jp) {
        print("execution((@com.sufanx..Secure *)  *(..))", jp);
    }

    @Before(value = "execution(* (@com.sufanx..Secure *).*(..))")
    public void executionTest14(JoinPoint jp) {
        print("execution(*  (@com.sufanx..Secure *).*(..))", jp);
    }

    @Before(value = "execution(* *(@com.sufanx..Secure *, @com.sufanx..Secure *))")
    public void executionTest15(JoinPoint jp) {
        print("execution(* *(@com.sufanx..Secure (*) , @com.sufanx..Secure (*)))", jp);
    }

    @Before(value = "execution(* *((@com.sufanx..Secure *)))")
    public void executionTest16_1(JoinPoint jp) {
        print("execution(* *((@com.sufanx..Secure *)))", jp);
    }

    @Before(value = "execution(* *(@com.sufanx..Secure *))")
    public void executionTest16_2(JoinPoint jp) {
        print("execution(* *(@com.sufanx..Secure *))", jp);
    }


    @Before(value = "execution(* *(@com.sufanx..Secure (@com.sufanx..Secure *), @com.sufanx..Secure (@com.sufanx..Secure *)))")
    public void executionTest17(JoinPoint jp) {
        print("execution(* *(@com.sufanx..Secure (@com.sufanx..Secure *), @com.sufanx..Secure (@com.sufanx..Secure *)))", jp);
    }

    @Before(value = "execution(* *(java.util.Map<com.sufanx..Model, com.sufanx..Model>, ..))")
    public void executionTest18(JoinPoint jp) {
        print("execution(* *(java.util.Map<com.sufanx..Model, com.sufanx..Model>, ..))", jp);
    }

    @Before(value = "execution(* *(java.util.HashMap<com.sufanx..Model, com.sufanx..Model>, ..))")
    public void executionTest18_1(JoinPoint jp) {
        print("execution(* *(java.util.HashMap<com.sufanx..Model, com.sufanx..Model>, ..))", jp);
    }

    @Before(value = "execution(* *(java.util.Collection<@com.sufanx..Secure *>))")
    public void executionTest19(JoinPoint jp) {
        print("execution(* *(java.util.Collection<@com.sufanx..Secure *>))", jp);
    }

    @Before(value = "execution(* *(java.util.Set<? extends java.util.HashMap>))")
    public void executionTest20(JoinPoint jp) {
        //不正常工作
        print("execution(* *(java.util.Set<? extends java.util.HashMap>))", jp);
    }

    @Before(value = "execution(* *(java.util.Stack<? super java.util.HashMap>))")
    public void executionTest21(JoinPoint jp) {
        //不正常工作
        print("execution(* *(java.util.Stack<? super java.util.HashMap>))", jp);
    }


    @Before(value = "execution(* *(*<@com.sufanx..Secure *>))")
    public void executionTest22(JoinPoint jp) {
        //不正常工作
        print("execution(* *(*<@com.sufanx..Secure *>))", jp);
    }

    /*
     * Execution Start
     */

    /*
     * Within Start
     */

    @Before(value = "within(com.sufanx..*)")
    public void withinTest1(JoinPoint jp) {
        print("within(com.sufanx..*)", jp);
    }

    @Before(value = "within(com.sufanx..IPointcutService+) ")
    public void withinTest2(JoinPoint jp) {
        print("within(com.sufanx..PointcutServiceImpl+) ", jp);
    }

    @Before(value = "within(@com.sufanx..Secure *)")
    public void withinTest3(JoinPoint jp) {
        print("within(@com.sufanx..Secure *)", jp);
    }


    @DeclareParents(value = "com.sufanx..IPointcutService+", defaultImpl = LogoutServiceImpl.class)
    private LogoutService introductionService;
    /*
     * Within End
     */

    /*
     * This Start
     */

    @Before(value = "this(com.sufanx.service.PointcutService)")
    public void thisTest1(JoinPoint jp) {
        print("this(com.sufanx..PointcutServiceImpl)", jp);
    }

    @Before(value = "this(com.sufanx.service.LogoutService)")
    public void thisTest2(JoinPoint jp) {
        print("this(com.sufanx..LogoutService)", jp);
    }
    /*
     * This End
     */

    /*
     * Target Start
     */

    @Before(value = "target(com.sufanx.service.PointcutService)")
    public void targetTest1(JoinPoint jp) {
        print("target(com.sufanx..PointcutServiceImpl)", jp);
    }

    @Before(value = "target(com.sufanx.service.LogoutService)")
    public void targetTest2(JoinPoint jp) {
        //注意与this(com.sufanx.service.LogoutService)区别
        print("target(com.sufanx..LogoutService)", jp);
    }
    /*
     * Target End
     */

    /*
     * Args
     */

    @Before(value = "args(java.io.Serializable, ..)")
    public void argsTest1(JoinPoint jp) {
        print("args(java.io.Serializable, ..)", jp);
    }

    /*
     * @within Start
     */

    @Before(value = "@within(com.sufanx.pointcut.Secure)")
    public void annotationWithinTest1(JoinPoint jp) {
        print("@within(com.sufanx.pointcut.Secure)", jp);
    }

    /*
     * @target
     */

    @Before(value = "@target(com.sufanx.pointcut.Secure)")
    public void annotationTargetTest1(JoinPoint jp) {
        print("@target(com.sufanx.pointcut.Secure)", jp);
    }

    /*
     * @args
     */

    @Before(value = "@args(com.sufanx.pointcut.Secure)")
    public void annotationArgsTest1(JoinPoint jp) {
        print("@args(com.sufanx.pointcut.Secure)", jp);
    }

    /*
     * @annotation
     */

    @Before(value = "@annotation(com.sufanx.pointcut.Secure)")
    public void annotationAnnotationTest1(JoinPoint jp) {
        print("@annotation(com.sufanx.pointcut.Secure)", jp);
    }

    /*
     * bean
     */

    @Before(value = "bean(*Service)")
    public void beanTest1(JoinPoint jp) {
        print("bean(*Service)", jp);
    }

    /*
     * Reference pointcut Start
     */

    @Pointcut(value = "bean(*Service)")
    private void pointcut1() {
    }

    @Pointcut(value = "@args(com.sufanx.pointcut.Secure)")
    private void pointcut2() {
    }

    @Before(value = "pointcut1() && pointcut2()")
    public void referencePointcutTest1(JoinPoint jp) {
        print("pointcut1() && pointcut2()", jp);
    }


    @Before(value = "com.sufanx.pointcut.ReferencePointcutAspect.pointcut()")
    public void referencePointcutTest2(JoinPoint jp) {
        print("com.sufanx.pointcut.ReferencePointcutAspect.pointcut()", jp);
    }

    /*
     * Reference pointcut End
     */

    private void print(String expression, JoinPoint jp) {
        System.out.println("[" + expression + "] matches [" + jp.getSignature().toLongString() + "]");
    }
}