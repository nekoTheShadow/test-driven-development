package money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        var five = new Doller(5);
        var product = five.times(2);

        assertThat(product.amount).isEqualTo(10);
        
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }
    
    @Test
    public void testEquality() {
        assertTrue(new Doller(5).equals(new Doller(5)));
    }
}
