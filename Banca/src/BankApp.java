public class BankApp {
    public static void main(String[] args) {
        BankAcc account = new BankAcc(50, "Cosmin");
        try {
            account.deposit(30);
            account.withdraw(20);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
