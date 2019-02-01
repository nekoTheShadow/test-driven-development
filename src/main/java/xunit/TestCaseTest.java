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
    
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
    }
}
