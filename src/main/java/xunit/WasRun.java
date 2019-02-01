package xunit;

public class WasRun {
    Integer wasRun;
    private String name;
    
    public WasRun(String name) {
        this.wasRun = null;
        this.name = name;
    }
    
    private void testMethod() {
        this.wasRun = 1;
    }

    public void run() {
        try {
            var method = this.getClass().getDeclaredMethod(name);
            method.setAccessible(true);
            method.invoke(this);
        } catch (ReflectiveOperationException e) {
            throw new XUnitRuntimeException(e);
        }
    }

}
