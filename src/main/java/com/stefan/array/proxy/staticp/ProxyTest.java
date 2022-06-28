package com.stefan.array.proxy.staticp;

public class ProxyTest {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        Proxy proxy = new Proxy(target);
        String result = proxy.execute();
        System.out.println(result);
    }
}
