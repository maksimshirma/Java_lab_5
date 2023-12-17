package org.lab;

import java.io.IOException;

/**
 * The Main class.
 */
public class App 
{
    /**
     * The Main method.
     * @param args - String[].
     * @throws IOException - exception that is thrown when an I/O error occurs.
     * @throws InstantiationException - instance creation exception.
     * @throws IllegalAccessException - exception to instantiation without access to the definition of the specified class, field, method, or constructor.
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        SomeBean sb = (new Injector<SomeBean>("src/main/java/config/inj.properties").inject(new SomeBean()));
        sb.run();
    }
}
