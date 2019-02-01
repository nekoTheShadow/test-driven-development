package xunit;

public class WasRun extends TestCase {
    Integer wasRun;
    Integer wasSetUp;
    String log;
    
    public WasRun(String name) {
        super(name);
    }
    
    public void setUp() {
        this.wasRun = null;
        this.wasSetUp = 1;
        this.log = "setUp ";
    }
    
    public void testMethod() {
        this.wasRun = 1;
    }
}
