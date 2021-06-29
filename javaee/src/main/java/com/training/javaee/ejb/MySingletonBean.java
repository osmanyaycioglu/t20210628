package com.training.javaee.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class MySingletonBean {

    private final AtomicInteger total   = new AtomicInteger();
    private int                 totalVal;
    List<String>                strList = Collections.synchronizedList(new ArrayList<>());
    Map<String, String>         map     = new ConcurrentHashMap<>();

    public synchronized void addToTotal(final int delta) {
        this.totalVal += delta;
    }

    public MySingletonBean() {
    }

    // @Lock(LockType.WRITE)
    public int add(final int i1,
                   final int i2) {
        int temp = i1 + i2;
        this.total.addAndGet(temp);
        return temp;
    }

    // @Lock(LockType.WRITE)
    public int subs(final int i1,
                    final int i2) {
        int temp = i1 - i2;
        this.total.addAndGet(temp);
        return temp;
    }


    public int getTotal() {
        return this.total.get();
    }


}
