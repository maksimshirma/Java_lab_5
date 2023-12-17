package org.lab;

import java.io.IOException;

public class App 
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {

        SomeBean sb = (new Injector<SomeBean>("src/main/java/config/inj.properties").inject(new SomeBean()));
        sb.run();
    }
}
