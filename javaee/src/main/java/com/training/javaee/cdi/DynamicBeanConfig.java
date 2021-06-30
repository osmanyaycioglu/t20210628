package com.training.javaee.cdi;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class DynamicBeanConfig {

    @Produces
    @Named("dyn")
    @ApplicationScoped
    public IProcess dynCreateBean() {
        Random randomLoc = new Random();
        EProcess[] valuesLoc = EProcess.values();
        int index = randomLoc.nextInt(valuesLoc.length);
        DynamicProcess dynamicProcessLoc = new DynamicProcess(valuesLoc[index]);
        return dynamicProcessLoc;
    }

    @Produces
    @Named("dyn2")
    public IProcess dynCreateBean2() {
        Random randomLoc = new Random();
        int index = randomLoc.nextInt(3);
        switch (index) {
            case 0:
                return new AddProcess();
            case 1:
                return new SubsProcess();
            case 2:
                return new MultiplyProcess();
            default:
                return new AddProcess();
        }
    }

}
