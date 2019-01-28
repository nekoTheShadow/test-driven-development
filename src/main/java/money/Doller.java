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
        var money = (Money) object;
        return amount == money.amount;
    }
}
