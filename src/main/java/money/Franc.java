package money;

public class Franc extends Money {
    private String currency;
    
    public Franc(int amount) {
        this.amount = amount;
        this.currency = "CHF";
    }
    
    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }
    
    public String currency() {
        return currency;
    }
}
