package money;

public class Doller extends Money {
    public Doller(int amount) {
        this.amount = amount;
    }
    
    public Doller times(int multipiler) {
        return new Doller(amount * multipiler);
    }
    
    @Override
    public boolean equals(Object object) {
        var doller = (Doller) object;
        return amount == doller.amount;
    }
}
