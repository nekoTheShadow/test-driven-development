package xunit;

public class TestCase {
    private String name;
    
    public TestCase(String name) {
        this.name = name;
    }
    
    public void setUp() {}
    public void tearDown() {}
    
    public void run() {
        setUp();
        try {
            var method = this.getClass().getDeclaredMethod(name);
            method.setAccessible(true);
            method.invoke(this);
        } catch (ReflectiveOperationException e) {
            throw new XUnitRuntimeException(e);
        }
        tearDown();
    }
}
