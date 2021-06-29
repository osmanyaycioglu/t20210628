package com.training.javaee.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class MyStatefulBean implements Serializable {


    private static final long serialVersionUID = 3190555440760270640L;

    private int               total;

    public MyStatefulBean() {
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


    @Remove
    public void xyz() {
        System.out.println("removed stateful bean");
    }

    @PrePassivate
    public void prePasif() {
        // Resource close
    }

    @PostActivate
    public void postAktif() {
        // Resource geri al aç
    }

    public int getTotal() {
        return this.total;
    }


    public void setTotal(final int totalParam) {
        this.total = totalParam;
    }

}
