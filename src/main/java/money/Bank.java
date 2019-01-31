package money;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Pair, Integer> rates = new HashMap<>();
    
    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {
        return from.equals(to) ? 1 : rates.get(new Pair(from, to));
    }
}
