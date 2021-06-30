package com.training.javaee.cdi;

import javax.inject.Named;

@Named("add")
public class AddProcess implements IProcess {

    @Override
    public int process(final int val1Param,
                       final int val2Param) {
        return val1Param + val2Param;
    }

}
