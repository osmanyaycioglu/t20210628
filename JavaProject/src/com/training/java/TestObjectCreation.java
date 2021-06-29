package com.training.java;


public class TestObjectCreation {

    public static void main(final String[] args) {
        IHello m = new MyObject();
        MyOtherObjh myOtherObjhLoc = new MyOtherObjh();
        myOtherObjhLoc.setMyObject(m);
        // Ready
        myOtherObjhLoc.doSomething();
    }
}
