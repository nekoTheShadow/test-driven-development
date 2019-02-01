package xunit;

import java.util.function.Supplier;

public class XUnitRuntimeException extends RuntimeException {
    public XUnitRuntimeException(Throwable cause) {
        super(cause);
    }
    
    public XUnitRuntimeException() {
        super();
    }
    
    public static void assertion(Supplier<Boolean> condition) {
        if (!condition.get()) {
            throw new XUnitRuntimeException();
        }
    }
}
