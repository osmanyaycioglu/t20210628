package com.training.java;


public class MyOtherObjh {

    private IHello myObject;

    public void doSomething() {
        this.myObject.hello();
    }

    public IHello getMyObject() {
        return myObject;
    }

    public void setMyObject(IHello myObjectParam) {
        myObject = myObjectParam;
    }


}
