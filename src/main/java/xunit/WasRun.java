package xunit;

public class WasRun extends TestCase {
    Integer wasRun;
    Integer wasSetUp;
    private String name;
    
    public WasRun(String name) {
        super(name);
        this.wasRun = null;
    }
    
    public void setUp() {
        this.wasSetUp = 1;
    }
    
    public void testMethod() {
        this.wasRun = 1;
    }
}
