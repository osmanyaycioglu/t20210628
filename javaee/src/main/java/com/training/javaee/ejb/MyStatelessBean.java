package com.training.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MyStatelessBean {

    private int total;

    public MyStatelessBean() {
    }

    public int add(final int i1,
                   final int i2) {
        int temp = i1 + i2;
        this.total += temp;
        return temp;
    }

    public int subs(final int i1,
                    final int i2) {
        int temp = i1 - i2;
        this.total += temp;
        return temp;
    }


    public int getTotal() {
        return this.total;
    }


    public void setTotal(final int totalParam) {
        this.total = totalParam;
    }

}
