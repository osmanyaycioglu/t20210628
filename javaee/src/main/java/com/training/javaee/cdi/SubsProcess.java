package com.training.javaee.cdi;

import javax.inject.Named;

@Named("subs")
public class SubsProcess implements IProcess {

    @Override
    public int process(final int val1Param,
                       final int val2Param) {
        return val1Param - val2Param;
    }

}
