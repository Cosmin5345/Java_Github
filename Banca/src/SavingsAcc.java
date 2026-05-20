public class SavingsAcc extends BankAcc {
    private float rate;

    public SavingsAcc() {
        this.rate = 0;
    }

    public SavingsAcc(float balance, String holder, float rate) {
        super(balance, holder);
        this.rate = rate;
    }

    public float getRate() { return rate; }
}
