package xunit;

public class WasRun extends TestCase {
    Integer wasRun;
    Integer wasSetUp;
    
    public WasRun(String name) {
        super(name);
    }
    
    public void setUp() {
        this.wasRun = null;
        this.wasSetUp = 1;
    }
    
    public void testMethod() {
        this.wasRun = 1;
    }
}
