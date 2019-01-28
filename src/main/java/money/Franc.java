package money;

public class Franc {
    private int amount;
    
    public Franc(int amount) {
        this.amount = amount;
    }
    
    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }
    
    @Override
    public boolean equals(Object object) {
        var doller = (Franc) object;
        return amount == doller.amount;
    }
}
