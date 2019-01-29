package money;

public class Doller extends Money {
    public Doller(int amount, String currency) {
        super(amount, currency);
    }
    
    public Money times(int multipiler) {
        return Money.dollar(amount * multipiler);
    }
}
