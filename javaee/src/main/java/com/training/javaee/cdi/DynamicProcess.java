package com.training.javaee.cdi;

import java.io.Serializable;

public class DynamicProcess implements IProcess, Serializable {

    private static final long serialVersionUID = -2846242065235659319L;

    private final EProcess    process;

    public DynamicProcess(final EProcess process) {
        this.process = process;
    }

    @Override
    public int process(final int val1Param,
                       final int val2Param) {
        return this.process.proc(val1Param,
                                 val2Param);
    }

}
