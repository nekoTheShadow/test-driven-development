package xunit;

public class WasRun extends TestCase {
    Integer wasRun;
    String log;
    
    public WasRun(String name) {
        super(name);
    }
    
    public void setUp() {
        this.wasRun = null;
        this.log = "setUp ";
    }
    
    public void testMethod() {
        this.wasRun = 1;
        this.log += "testMethod ";
    }
}
