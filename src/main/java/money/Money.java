package money;

public class Money implements Expression {
    protected int amount;
    protected String currency;
    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }
    public boolean equals(Object object) {
        var money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }
    public String toString() {
        return String.format("%d %s", amount, currency);
    }
    public String currency() {
        return currency;
    }
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }    
    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
    public Sum plus(Money addend) {
        return new Sum(this, addend);
    }
    public Money reduce(String to) {
        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
        return new Money(amount / rate, to);
    }    
}
