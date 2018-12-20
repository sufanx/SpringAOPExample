package com.sufanx.advice.xml;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdviceImpl implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("> (Advisor)beforeAdvice：准备登录");
    }

}
