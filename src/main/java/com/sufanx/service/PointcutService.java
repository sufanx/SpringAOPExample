package com.sufanx.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.sufanx.pointcut.Model;
import com.sufanx.pointcut.Secure;

/**
 * @author shuyufan
 */
public interface PointcutService {

    boolean test();

    boolean test(Object obj);

    boolean test(Date date);

    Model test(Model model);

    void test(@Secure String str1, @Secure String str2);

    void test(@Secure Model model1, @Secure Model model2);

    void test(Map<Model, Model> map);

    void test(Map map, int i);

    void test(HashMap<Model, Model> map, String str);

    void test(Collection<Model> collection);

    void test(Set<TestMap> set);

    void test(Stack<Map> list);

    class TestMap extends HashMap {
    }
}
