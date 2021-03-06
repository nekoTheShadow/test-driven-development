package xunit;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }
    
    private TestResult result;
    
    public void setUp() {
        result = new TestResult();
    }

    public void testTemplateMethod() {
        var test = new WasRun("testMethod");
        test.run(result);
        XUnitRuntimeException.assertion(() -> test.log.equals("setUp testMethod tearDown "));
    }
    
    public void testResult() {
        var test = new WasRun("testMethod");
        test.run(result);
        XUnitRuntimeException.assertion(() -> result.summary().equals("1 run, 0 failed"));
    }
    
    public void testFailedResult() {
        var test = new WasRun("testBrokenMethod");
        test.run(result);
        XUnitRuntimeException.assertion(() -> result.summary().equals("1 run, 1 failed"));
    }
    
    public void testFailedResultFormatting() {
        result.testStarted();
        result.testFailed();
        XUnitRuntimeException.assertion(() -> result.summary().equals("1 run, 1 failed"));
    }
    
    public void testSuite() {
        var suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        suite.run(result);
        XUnitRuntimeException.assertion(() -> result.summary().equals("2 run, 1 failed"));
    }
    
    public static void main(String[] args) {
        var suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testFailedResult"));
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        suite.add(new TestCaseTest("testSuite"));
        
        var result = new TestResult();
        suite.run(result);
        
        System.out.println(result.summary());
    }
}
