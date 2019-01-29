package money;

public class Doller extends Money {
    public Doller(int amount) {
        this.amount = amount;
    }
    
    public Money times(int multipiler) {
        return new Doller(amount * multipiler);
    }
}
