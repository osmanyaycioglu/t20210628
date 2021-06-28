package com.training.java.prop;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyRun {

    public static void main(final String[] args) throws Exception {

        File file = new File("my.properties");
        FileInputStream fileInputStreamLoc = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStreamLoc);
        MyAppConfig appConfigLoc = new MyAppConfig();
        String propertyLoc = properties.getProperty("app.port");
        appConfigLoc.setPort(Integer.parseInt(propertyLoc));
        appConfigLoc.setName(properties.getProperty("app.name"));
        appConfigLoc.setDesc(properties.getProperty("app.desc"));
        appConfigLoc.setDest(properties.getProperty("app.dest"));

        System.out.println("Props : " + appConfigLoc);

        File file2 = new File("my2.properties");
        FileInputStream fileInputStream2Loc = new FileInputStream(file2);
        Properties properties2 = new Properties();
        properties.load(fileInputStreamLoc);
        MyAppConfig2 appConfig2Loc = new MyAppConfig2();
        propertyLoc = properties.getProperty("app.port");
        appConfig2Loc.setPort(Integer.parseInt(propertyLoc));
        appConfig2Loc.setName(properties.getProperty("app.name"));
        appConfig2Loc.setDesc(properties.getProperty("app.desc"));
        appConfig2Loc.setDest(properties.getProperty("app.dest"));

        System.out.println("Props : " + appConfigLoc);

    }
}
