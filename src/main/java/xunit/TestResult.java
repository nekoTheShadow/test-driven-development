package xunit;

public class TestResult {
    private int runCount = 0;
    private int errorCount = 0;
    
    public void testStarted() {
        runCount++;
    }
    
    public void testFailed() {
        errorCount++;
    }
    
    public String summary() {
        return String.format("%d run, %d failed", runCount, errorCount);
    }
}
