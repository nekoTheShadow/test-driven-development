package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() {
        var test = new WasRun("testMethod");
        XUnitRuntimeException.assertion(() -> test.wasRun == null);
        test.run();
        XUnitRuntimeException.assertion(() -> test.wasRun != null);
    }
    
    public void testSetUp() {
        var test = new WasRun("testMethod");
        test.run();
        XUnitRuntimeException.assertion(() -> test.wasSetUp != null);
    }
    
    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}
