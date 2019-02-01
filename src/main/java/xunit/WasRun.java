package xunit;

public class WasRun {
    Integer wasRun;
    
    public WasRun(String name) {
        this.wasRun = null;
    }
    
    private void testMethod() {
        this.wasRun = 1;
    }

    public void run() {
        testMethod();
    }

}
