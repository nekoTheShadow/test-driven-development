package money;

public class Doller extends Money {
    public Doller(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    public Money times(int multipiler) {
        return Money.dollar(amount * multipiler);
    }
}
