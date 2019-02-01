package xunit;

public class TestResult {
    private int runCount = 0;
    
    public void testStarted() {
        runCount++;
    }
    
    public String summary() {
        return String.format("%d run, 0 failed", runCount);
    }
}
