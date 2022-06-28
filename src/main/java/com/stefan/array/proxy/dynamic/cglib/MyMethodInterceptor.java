package com.stefan.array.proxy.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>>>>>>>>>>MethodInterceptor start...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(">>>>>>>>>>>>MethodInterceptor ending...");
        return "result";
    }
}
