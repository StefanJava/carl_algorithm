package com.stefan.array.proxy.staticp;

public class Proxy implements Target {

    private Target target;

    public Proxy(Target target) {
        this.target = target;
    }

    @Override
    public String execute() {

        System.out.println("preProcess");
        String result = this.target.execute();
        System.out.println("postProcess");
        return result;
    }
}
