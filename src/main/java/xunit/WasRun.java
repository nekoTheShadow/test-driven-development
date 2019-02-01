package xunit;

public class WasRun extends TestCase {
    Integer wasRun;
    private String name;
    
    public WasRun(String name) {
        super(name);
        this.wasRun = null;
    }
    
    public void testMethod() {
        this.wasRun = 1;
    }
}
