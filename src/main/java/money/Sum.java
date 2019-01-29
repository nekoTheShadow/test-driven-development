package money;

public class Sum implements Expression {
    protected Money augend;
    protected Money addend;
    
    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

}
