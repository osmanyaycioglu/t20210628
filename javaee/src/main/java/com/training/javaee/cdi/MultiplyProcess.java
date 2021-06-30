package com.training.javaee.cdi;

@MultiplyBean
public class MultiplyProcess implements IProcess {

    @Override
    public int process(final int val1Param,
                       final int val2Param) {
        return val1Param * val2Param;
    }

}
