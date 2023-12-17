package reflection;

/**
 * Class inheriting class SomeInterface.
 */
public class SomeImpl implements SomeInterface {

    /**
     * Override method from SomeOtherInterface.
     */
    @Override
    public void doSome() {
        System.out.println("A");
    }
}
