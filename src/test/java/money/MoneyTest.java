package money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        var five = Money.dollar(5);
        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }
    
    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }
    
    @Test
    public void testCurrency() {
        assertThat(Money.dollar(1).currency()).isEqualTo("USD");
        assertThat(Money.franc(1).currency()).isEqualTo("CHF");
    }
    
    @Test
    public void testSimpleAddition() {
        var five = Money.dollar(5);
        var sum = five.plus(five);
        var bank = new Bank();
        var reduced = bank.reduce(sum, "USD");
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }
    
    @Test
    public void testPlusReturnsSum() {
        var five = Money.dollar(5);
        var result = five.plus(five);
        var sum = (Sum) result;
        assertThat(sum.augend).isEqualTo(five);
        assertThat(sum.addend).isEqualTo(five);
    }
}
