public class Bank {
    private double balance;

    public Bank() {
        balance = 1000000;
    }

    public static Bank getBank(){
        return new Bank();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public void showBalance(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Поточний баланс казино: "+balance);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
