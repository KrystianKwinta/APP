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

        if (amount < value) {
            goToNextBanknote(amount);
        } else {
            int banknotesToWithdraw = amount / value;
            int rest = amount % value;
            if (banknotesToWithdraw <= quantity) {
                withdrawMoney(banknotesToWithdraw);
                quantity -= banknotesToWithdraw;
            } else {
                int banknotesUnableToWithdraw = 0;
                if (quantity != 0) {
                    withdrawMoney(quantity);
                    banknotesUnableToWithdraw = banknotesToWithdraw - quantity;
                    quantity = 0;

                } else {
                    banknotesUnableToWithdraw = banknotesToWithdraw;
                }
                rest += banknotesUnableToWithdraw * value;
            }

            if (rest != 0) {
                goToNextBanknote(rest);
            }
            if (rest == 0) {
                for (String el : ResultListSingleton.getInstance().getList()) {
                    System.out.println(el);
                }
                ResultListSingleton.getInstance().clearResult();
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

    private void withdrawMoney(int banknotesToWithdraw) {
        String toSave = String.format("%s * %s", banknotesToWithdraw, value);
        ResultListSingleton.getInstance().addToResult(toSave);
    }


 /*   public void getQuantity(Banknote banknote){
        System.out.println(this.quantity);
    }*/



}