package com.stefan.array.proxy.dynamic.jdk;

public class TargetImpl implements Target {
    @Override
    public String execute() {

        System.out.println("TargetImpl execute!");
        return "execute";
    }
}
