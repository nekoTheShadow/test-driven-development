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
    

    public static void main(String[] args) {
        var tct = new TestCaseTest("testRunning");
        tct.run();
    }
}
