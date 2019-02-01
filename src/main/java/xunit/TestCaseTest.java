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
    
    public void testFailedResultFormatting() {
        var result = new TestResult();
        result.testStarted();
        result.testFailed();
        XUnitRuntimeException.assertion(() -> result.summary().equals("1 run, 1 failed"));
    }
    
    public static void main(String[] args) {
        System.out.println(new TestCaseTest("testTemplateMethod").run().summary());
        System.out.println(new TestCaseTest("testResult").run().summary());
        System.out.println(new TestCaseTest("testFailedResult").run().summary());
        System.out.println(new TestCaseTest("testFailedResultFormatting").run().summary());
    }
}
