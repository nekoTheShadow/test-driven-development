package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testTemplateMethod() {
        var test = new WasRun("testMethod");
        test.run();
        XUnitRuntimeException.assertion(() -> test.log.equals("setUp testMethod tearDown "));
    }
    
    public void testResult() {
        var test = new WasRun("testMethod");
        var result = test.run();
        XUnitRuntimeException.assertion(() -> result.summary().equals("1 run, 0 failed"));
    }
    
    public void testFailedResult() {
        var test = new WasRun("testBrokenMethod");
        var result = test.run();
        XUnitRuntimeException.assertion(() -> result.summary().equals("1 run, 1 failed"));
    }
    
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
        new TestCaseTest("testResult").run();
//        new TestCaseTest("testFailedResult").run();
    }
}
