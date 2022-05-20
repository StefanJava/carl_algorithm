package com.stefan.test;

public class Test {

    {
        i = i + 1;
        System.out.println("代码块1： " + i);
    }

    private static int i = 10;

    static {
        System.out.println("静态代码块1: " + i);
    }

    public Test() {
        System.out.println("构造方法: " + i);
    }

    {
        i = i + 1;
        System.out.println("代码块2： " + i);
    }

    static {
        i = i + 1;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int i = 9;
        System.out.println("main方法中：" + i);

        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (a == aa)
            System.out.println("a==aa");
        if (42 == 42.0) { // true
            System.out.println("true");
        }

        String c = "c";
        String d = "d";
        String cd = "cd";
        String cd2 = "c" + "d";
        System.out.println(cd == cd2);
    }

    static {
        System.out.println("静态代码块2：" + i);
    }
}
