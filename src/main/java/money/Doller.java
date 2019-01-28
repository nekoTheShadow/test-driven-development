package money;

public class Doller extends Money {
    public Doller(int amount) {
        this.amount = amount;
    }
    
    public Doller times(int multipiler) {
        return new Doller(amount * multipiler);
    }
}
