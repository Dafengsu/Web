package com.hzau.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

/**
 * @author su
 * @description
 * @date 2020/2/21
 */
public class ChildImpl implements Child {
    public static void main(String[] args) {
        ChildImpl child1 = new ChildImpl();
        Child child = (Child) Proxy.newProxyInstance(child1.getClass().getClassLoader(),child1.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(child1, args);
            }
        });
        child.test();
    }
    @Override
    public void test() {

    }
}
