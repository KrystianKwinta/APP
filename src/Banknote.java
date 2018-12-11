import java.util.HashMap;

public interface Banknote {
    void next(Banknote banknote);

    void withdraw(int amount);

    int getQ();
    String getName();

    void getQuantity(HashMap<String, Integer> map);
    HashMap<String, Integer> quantityToMap();

}