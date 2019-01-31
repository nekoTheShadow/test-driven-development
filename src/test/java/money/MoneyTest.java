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
    
    @Test
    public void testReduceSum() {
        var sum = new Sum(Money.dollar(3), Money.dollar(4));
        var bank = new Bank();
        assertThat(bank.reduce(sum, "USD")).isEqualTo(Money.dollar(7));
    }
    
    @Test
    public void testReduceMoney() {
        var bank = new Bank();
        assertThat(bank.reduce(Money.dollar(1), "USD")).isEqualTo(Money.dollar(1)); 
    }
    
    @Test
    public void testReduceMoneyDifferentCurrency() {
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        assertThat(bank.reduce(Money.franc(2), "USD")).isEqualTo(Money.dollar(1));
    }
    
    @Test
    public void testIdentityRate() {
        assertThat(new Bank().rate("USD", "USD")).isEqualTo(1);
    }
    
    @Test
    public void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        assertThat(bank.reduce(fiveBucks.plus(tenFrancs), "USD")).isEqualTo(Money.dollar(10));
    }
    
    @Test
    public void testSumPlusMoney() {
        var fiveBucks = Money.dollar(5);
        var tenFrancs = Money.franc(10);
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        assertThat(bank.reduce(sum, "USD")).isEqualTo(Money.dollar(15));
    }
    
    @Test
    public void testSumTimes() {
        var fiveBucks = Money.dollar(5);
        var tenFrancs = Money.franc(10);
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var sum = new Sum(fiveBucks, tenFrancs).times(2);
        assertThat(bank.reduce(sum, "USD")).isEqualTo(Money.dollar(20));
    }
}
