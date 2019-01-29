package money;

public class Doller extends Money {
    private String currency;
    
    public Doller(int amount) {
        this.amount = amount;
        this.currency = "USD";
    }
    
    public Money times(int multipiler) {
        return new Doller(amount * multipiler);
    }
    
    public String currency() {
        return currency;
    }
}
