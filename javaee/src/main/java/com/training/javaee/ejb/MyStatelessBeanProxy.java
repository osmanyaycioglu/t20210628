package com.training.javaee.ejb;

public class MyStatelessBeanProxy extends MyStatelessBean {

    private final MyStatelessBean myStatelessBean;

    public MyStatelessBeanProxy(final MyStatelessBean myStatelessBean) {
        this.myStatelessBean = myStatelessBean;
    }

    @Override
    public int add(final int i1,
                   final int i2) {
        // Java EE Container pool dan MyStatelessBean al
        int addLoc = this.myStatelessBean.add(i1,
                                              i2);
        // Java EE Container pool a MyStatelessBean geri koy
        return addLoc;
    }

    @Override
    public int subs(final int i1,
                    final int i2) {
        // Java EE Container pool dan MyStatelessBean al
        int addLoc = this.myStatelessBean.subs(i1,
                                               i2);
        // Java EE Container pool a MyStatelessBean geri koy
        return addLoc;
    }


}
