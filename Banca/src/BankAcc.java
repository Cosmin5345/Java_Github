public class BankAcc {
    private float balance;
    private String holder;

    public BankAcc() {
        this.balance = 0;
        this.holder = "Necunoscut";
    }

    public BankAcc(float balance, String holder) {
        this.balance = balance;
        this.holder = holder;
    }

    public float getBalance() { return balance; }
    public String getHolder() { return holder; }

    public void deposit(int value) throws InvalidAmountException {
        if (value <= 0)
            throw new InvalidAmountException("Suma invalida");
        balance += value;
    }

    public void withdraw(int value) throws InvalidAmountException, InsufficientFundsException {
        if (value <= 0)
            throw new InvalidAmountException("Suma invalida");
        if (balance < value)
            throw new InsufficientFundsException("Fonduri insuficiente pentru retragere");
        balance -= value;
    }
}
