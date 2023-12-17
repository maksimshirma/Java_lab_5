package org.lab;

import reflection.SomeInterface;
import reflection.SomeOtherInterface;

public class SomeBean {

    @AutoInjectable
    private SomeInterface firstField;
    @AutoInjectable
    private SomeOtherInterface secondField;

    public SomeBean() {}

    public void run(){
        firstField.doSome();
        secondField.doSome();
    }
}