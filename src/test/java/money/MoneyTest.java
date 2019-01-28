package money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        var five = new Doller(5);
        assertThat(five.times(2)).isEqualTo(new Doller(10));
        assertThat(five.times(3)).isEqualTo(new Doller(15));
    }
    
    @Test
    public void testEquality() {
        assertTrue(new Doller(5).equals(new Doller(5)));
        assertFalse(new Doller(5).equals(new Doller(6)));
    }
    
    @Test
    public void testFrancMultiplication() {
        var five = new Franc(5);
        assertThat(five.times(2)).isEqualTo(new Franc(10));
        assertThat(five.times(3)).isEqualTo(new Franc(15));
    }
}
