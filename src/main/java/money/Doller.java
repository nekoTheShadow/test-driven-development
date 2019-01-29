package money;

public class Doller extends Money {
    public Doller(int amount, String currency) {
        super(amount, currency);
    }
    
    public Money times(int multipiler) {
        return new Money(amount * multipiler, currency);
    }
}
