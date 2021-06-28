package com.training.java.prop.with.anno;

import com.training.java.prop.MyAppConfig;
import com.training.java.prop.MyAppConfig2;

public class PropAnnoRun {

    public static void main(final String[] args) throws Exception {
        MyAppConfig appConfigLoc = (MyAppConfig) PropEngine.readProp(MyAppConfig.class);
        System.out.println("Prop = " + appConfigLoc);
        MyAppConfig2 appConfig2Loc = (MyAppConfig2) PropEngine.readProp(MyAppConfig2.class);
        System.out.println("Prop = " + appConfig2Loc);

    }
}
