public class Card {
    private int id;
    private String password;
    private double balance;
    private double deposit;
    private double profit;
    private Session session;

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance + deposit;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit += deposit;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public static Card getCard(){
        return new Card();
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + getBalance() +
                ", deposit=" + deposit +
                ", profit=" + profit +
                '}';
    }
}
