package com.tzx.rpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author ÃÔ‘ÛˆŒ
 * @date 2020/4/7
 * @description
 */
public class ReflectUtilsTest {

    @Test
    public void newInstance() {
        TestClass testClass = ReflectUtils.newInstance(TestClass.class);
        assertNotNull(testClass);
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);

        String name  = methods[0].getName();
        assertEquals("b",name);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];

        TestClass testClass = new TestClass();
        Object result = ReflectUtils.invoke(testClass,b);

        assertEquals("b",result);
    }
}