package com.training.javaee.cdi;

import javax.enterprise.inject.Alternative;

@Alternative
public class SubsProcess2 implements IProcess {

    @Override
    public int process(final int val1Param,
                       final int val2Param) {
        return val1Param - val2Param;
    }

}
