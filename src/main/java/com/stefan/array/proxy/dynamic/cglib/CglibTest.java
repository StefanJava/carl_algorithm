package com.stefan.array.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        System.out.println("****************");
        CglibTest test = new CglibTest();
        Target proxyTarget = (Target) test.createProxy(Target.class);
        String res = proxyTarget.execute();
        System.out.println(res);
    }

    private Object createProxy(Class<?> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}
