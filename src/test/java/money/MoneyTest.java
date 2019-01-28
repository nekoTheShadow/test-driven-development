package money;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        var five = new Doller(5);
        five.times(2);
        assertThat(five.amount).isEqualTo(10);
    }
}
