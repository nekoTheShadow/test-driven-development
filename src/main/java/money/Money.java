package money;

public abstract class Money {
    protected int amount;
    protected String currency;
    public abstract Money times(int multiplier);
    public boolean equals(Object object) {
        var money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }
    public String currency() {
        return currency;
    }
    public static Money dollar(int amount) {
        return new Doller(amount, "USD");
    }    
    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }    
}
