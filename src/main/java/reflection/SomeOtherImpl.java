package reflection;

/**
 * Class inheriting class SomeInterface.
 */
public class SomeOtherImpl implements SomeInterface {

    /**
     * Override method from SomeInterface.
     */
    @Override
    public void doSome() {
        System.out.println("B");
    }
}