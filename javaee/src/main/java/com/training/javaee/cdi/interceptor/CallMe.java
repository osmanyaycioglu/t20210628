package com.training.javaee.cdi.interceptor;


public class CallMe {

    @AraKatman
    @CheckStr("osman")
    public String doSomething(final String str,
                              final int i) {
        return "Received : " + str + " val : " + i;
    }
}
