package com.stefan.array.proxy.staticp;

public class TargetImpl implements Target {
    @Override
    public String execute() {

        System.out.println("TargetImpl execute!");
        return "execute";
    }
}
