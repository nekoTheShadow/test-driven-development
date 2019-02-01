package xunit;

public class WasRun extends TestCase {
    String log;
    
    public WasRun(String name) {
        super(name);
    }
    
    public void setUp() {
        this.log = "setUp ";
    }
    
    public void tearDown() {
        this.log += "tearDown ";
    }
    
    public void testMethod() {
        this.log += "testMethod ";
    }
}
