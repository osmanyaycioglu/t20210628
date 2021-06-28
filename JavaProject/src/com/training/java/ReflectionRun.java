package com.training.java;


public class ReflectionRun {

    public static void main(final String[] args) {
        Class<MyObject> myObjCls = MyObject.class;
        MyAnno annotationLoc = myObjCls.getAnnotation(MyAnno.class);
        if (annotationLoc != null) {
            System.out.println(annotationLoc.str() + " " + annotationLoc.val());
        }
    }
}
