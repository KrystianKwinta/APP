import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ATM {

    private Banknote top;
    private static HashMap<String, Integer> quantityMap;

    public void configure(List<Banknote> banknotes) {
        this.top = banknotes.get(0);
        for (int i = 0; i < banknotes.size() - 1; i++) {
            Banknote banknote = banknotes.get(i);
            banknote.next(banknotes.get(i + 1));
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.configure(Arrays.asList(new B100(5), new B50(5), new B20(5), new B10(5), new B5(50)));
        atm.withdraw(50);
        quantityMap = atm.top.quantityToMap();
        System.out.println(quantityMap);
        atm.withdraw(150);
        quantityMap = atm.top.quantityToMap();
        System.out.println(quantityMap);
    }

    private void withdraw(int amount) {
        top.withdraw(amount);
    }


}