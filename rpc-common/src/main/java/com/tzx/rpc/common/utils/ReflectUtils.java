package com.tzx.rpc.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 田泽鑫
 * @date 2020/4/7
 * @description 反射工具类
 */
public class ReflectUtils {
    /**
     * @Author: tzx
     * @Description: 根据一个Class创建一个对象,使用泛型可直接得到期望的类型,调用默认的无参构造方法
     * @param clazz 待创建对象的类
     * @Date: 2020/4/7 3:12
     * @return: T  创建好的对象
     **/
    public static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    /**
     * @Author: tzx
     * @Description: 获取某个类的公有方法
     * @param clazz
     * @Date: 2020/4/7 3:19
     * @return: java.lang.reflect.Method[]
     **/
    public static Method[] getPublicMethods(Class clazz){
        //getDeclaredMethods拿到所有方法但不包括继承父类的方法,
        // 这里不需要获取一个类的父类的公用方法,所以不直接使用getMethods
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = new ArrayList<>();
        for (Method m:methods) {
            if (Modifier.isPublic(m.getModifiers())){
                pmethods.add(m);
            }
        }
        return pmethods.toArray(new Method[0]);
    }
    /**
     * @Author: tzx
     * @Description: 调用指定对象的指定方法
     * @param object 被调用的对象
     * @param method 被调用的方法
     * @param args	 可变参数,即传入的参数可以随意,不论传多少个参数都被放到一个数组里面
     * @Date: 2020/4/7 3:27
     * @return: java.lang.Object
     **/
    public static Object invoke(Object object,Method method,Object... args){
        try {
            return method.invoke(object,args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
