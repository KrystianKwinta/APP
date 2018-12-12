import java.util.HashMap;

public class CommonBanknote implements Banknote {

    private Banknote nextBanknote;
    private final int value;
    private int quantity;

    public CommonBanknote(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    @Override
    public void next(Banknote banknote) {
        this.nextBanknote = banknote;
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Amount to withdraw is: " +amount);
        if (amount < value) {
            goToNextBanknote(amount);
        }

        else {

            int banknotesToWithdraw = amount / value;
            int rest = amount % value;
            if (banknotesToWithdraw <= quantity) {
                quantity -= banknotesToWithdraw;
                System.out.println("Withdrawing: " + banknotesToWithdraw + " x " + value);
            }

            else {
                int banknotesUnableToWithdraw = 0;
                if (quantity != 0) {
                    banknotesUnableToWithdraw = banknotesToWithdraw - quantity;
                    quantity = 0;

                } else {
                    banknotesUnableToWithdraw = banknotesToWithdraw;
                }

                rest += banknotesUnableToWithdraw * value;
            }

            if (rest != 0) {
                System.out.println(rest +" to go...");
                goToNextBanknote(rest);
            }
            if (rest == 0) {
                System.out.println("Withdrawn whole sum.");
            }
        }
    }

    private void goToNextBanknote(int amount) {

        if (nextBanknote == null) {
            System.out.println("Cant withdraw money. Please change your request.");
        } else {
            nextBanknote.withdraw(amount);
        }
    }

    public void getQuantity(HashMap<String, Integer> map) {
        if (nextBanknote != null) {
            map.put(nextBanknote.getName(), nextBanknote.getQ());
            nextBanknote.getQuantity(map);
        }
    }

    public HashMap<String, Integer> quantityToMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(getClass().getSimpleName(), quantity);
        getQuantity(map);
        System.out.println("Current ATM status is : ");
        return map;

    }

    public int getQ() {
        return quantity;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

}
