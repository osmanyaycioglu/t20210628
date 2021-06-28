package com.training.java.prop.with.anno;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropEngine {

    public static Object readProp(final Class<?> clazz) throws Exception {
        PropFile annotationLoc = clazz.getAnnotation(PropFile.class);
        if (annotationLoc == null) {
            return null;
        }

        Object obj = clazz.getConstructor(null)
                          .newInstance(null);

        String valueLoc = annotationLoc.value();
        File file = new File(valueLoc);
        FileInputStream fileInputStreamLoc = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStreamLoc);
        Field[] declaredFieldsLoc = clazz.getDeclaredFields();
        for (Field fieldLoc : declaredFieldsLoc) {
            Prop propLoc = fieldLoc.getAnnotation(Prop.class);
            if (propLoc != null) {
                fieldLoc.setAccessible(true);
                String nameLoc = propLoc.name();
                String propertyLoc = properties.getProperty(nameLoc);
                Class<?> typeLoc = fieldLoc.getType();
                if (typeLoc.getName()
                           .equals("int")) {
                    fieldLoc.setInt(obj,
                                    Integer.parseInt(propertyLoc));
                } else if (typeLoc.getName()
                                  .equals(String.class.getName())) {
                    fieldLoc.set(obj,
                                 propertyLoc);
                }
            }
        }
        return obj;
    }

}
