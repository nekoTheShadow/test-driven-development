package money;

public class Doller {
    int amount;
    
    public Doller(int amount) {
        this.amount = amount;
    }
    
    public void times(int multipiler) {
        amount = amount * multipiler;
    }
}
