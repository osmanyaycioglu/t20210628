package com.training.java;


@MyAnno(str = "ali", val = 40)
public class MyObject implements IHello {

    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public void secondMethod() {
        System.out.println("Second");
    }

}
