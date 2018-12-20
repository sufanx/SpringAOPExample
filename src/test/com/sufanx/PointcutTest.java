package com.sufanx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sufanx.pointcut.Model;
import com.sufanx.service.PointcutService;
import com.sufanx.service.PointcutService.TestMap;

public class PointcutTest {

    private PointcutService pointcutService;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("pointcut.xml");
        pointcutService = ctx.getBean("pointcutService", PointcutService.class);
    }

    @Test
    public void empty() {
        pointcutService.test();
    }

    @Test
    public void blank() {
        pointcutService.test("");

        pointcutService.test("", "");
    }

    @Test
    public void date() {
        pointcutService.test(new Date());
    }

    @Test
    public void model() {
//        pointcutService.test(new Model());
        pointcutService.test(new Model(), new Model());
    }

    @Test
    public void hashMap() {
        pointcutService.test(new HashMap());
        pointcutService.test(new HashMap(), "");
        pointcutService.test(new HashMap(), 1);
    }

    @Test
    public void list() {
        pointcutService.test(new ArrayList());
    }

    @Test
    public void set() {
        pointcutService.test(new HashSet<TestMap>());
    }

    @Test
    public void stack() {
        pointcutService.test(new Stack<Map>());
    }

    @Test
    public void serializable() {
        pointcutService.test(new Serializable() {
        });
    }

    @Test
    public void test() {
        //用于测试@args 注意将掉用 public boolean test(Object obj);
        pointcutService.test((Object) new Model());
    }


}
