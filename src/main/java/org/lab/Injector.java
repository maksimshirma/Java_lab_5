package org.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector<T>{
    private final Properties properties;

    Injector(String pathToPropertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(pathToPropertiesFile)));
    }

    T inject(T obj) throws IOException, IllegalAccessException, InstantiationException {

        Class dp;
        Class cl = obj.getClass();

        Field[] fields = cl.getDeclaredFields();
        for (Field field: fields){
            if (field.getAnnotation(AutoInjectable.class) != null){
                String fieldType = field.getType().toString().split(" ")[1];
                String equalsClassName = properties.getProperty(fieldType, null);

                if (equalsClassName != null){
                    try {
                        dp = Class.forName(equalsClassName);
                    } catch (ClassNotFoundException e){
                        System.out.println("Not found class for " + equalsClassName);
                        continue;
                    }

                    field.setAccessible(true);
                    field.set(obj, dp.newInstance());
                }
                else {
                    System.out.println("Not found properties for field type " + fieldType);
                }
            }
        }
        return obj;
    }
}

