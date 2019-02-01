package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }
    
    private WasRun test;
    
    public void setUp() {
        this.test = new WasRun("testMethod");
    }

    public void testRunning() {
        test.run();
        XUnitRuntimeException.assertion(() -> test.wasRun != null);
    }
    
    public void testSetUp() {
        test.run();
        XUnitRuntimeException.assertion(() -> test.wasSetUp != null);
    }
    
    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}
