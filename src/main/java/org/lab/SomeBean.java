package org.lab;

import reflection.SomeInterface;
import reflection.SomeOtherInterface;

/**
 * Class that contains two annotations.
 */
public class SomeBean {

    @AutoInjectable
    private SomeInterface firstField;
    @AutoInjectable
    private SomeOtherInterface secondField;

    /**
     * Default constructor.
     */
    public SomeBean() {}

    /**
     * Calls interface methods from fields with annotations.
     */
    public void run(){
        firstField.doSome();
        secondField.doSome();
    }
}