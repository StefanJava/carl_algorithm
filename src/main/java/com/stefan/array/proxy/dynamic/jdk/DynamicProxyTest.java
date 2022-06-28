package com.stefan.array.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        DynamicProxyHandler handler = new DynamicProxyHandler(target);
        Target proxyInstance = (Target) Proxy.newProxyInstance(TargetImpl.class.getClassLoader(),
                TargetImpl.class.getInterfaces(), handler);
        String result = proxyInstance.execute();
        System.out.println(result);
    }
}
