package org.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class Injector that implements dependency injection into any object with fields marked as @AutoInjectable.
 */
public class Injector<T>{
    /**
     * Reference to the configuration object.
     */
    private final Properties properties;

    /**
     * Class constructor.
     * @param pathToPropertiesFile - path to the file.
     * @throws IOException - exception that is thrown when an I/O error occurs.
     */
    Injector(String pathToPropertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(pathToPropertiesFile)));
    }

    /**
     * Inject accepts an arbitrary object, examines it for the presence of fields with an AutoInjectable annotation.
     * If there is such a field, look at its type and look for an implementation in the ini.properties file.
     * @param obj - object of any class.
     * @return object with initialized fields with an Auto Injectable annotation.
     */
    T inject(T obj) throws IllegalAccessException, InstantiationException {

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

