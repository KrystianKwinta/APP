public interface Banknote {
    void next(Banknote banknote);
    //void getQuantity(Banknote banknote);
    void withdraw(int amount);

}